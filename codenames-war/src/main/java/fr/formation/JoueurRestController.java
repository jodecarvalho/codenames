package fr.formation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;
import fr.formation.model.Views;

@RestController
@RequestMapping("/api/joueur")
@CrossOrigin("*")
public class JoueurRestController {
	
	@Autowired
	IDAOJoueur daoJoueur;
	
	@Autowired
	IDAOPersonne daoPersonne;
	
	@GetMapping("/findJoueurBySession")
	@JsonView(Views.Joueur.class)
	public Joueur findJoueurBySession(HttpSession session) {//A mettre dans un PersonneRestController
		return (Joueur) session.getAttribute("joueur");
	}
	
	@PostMapping("/save")
	@JsonView(Views.Joueur.class)
	public Joueur save(@RequestBody Joueur joueur) {
		Joueur joueurSave = this.daoJoueur.save(joueur);
		
		//Pour prévenir qu'il y a une modification
		for(SseEmitter emitter : emitters) {
			try {
				emitter.send(joueurSave);//Envoi sur le JavaScript
			}catch(Exception ex) {
				emitter.completeWithError(ex);
			}
		}
		
		return joueurSave;
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.Joueur.class)
	public void delete(@PathVariable int id) {
		this.daoJoueur.deleteById(id);
	}

	private List<SseEmitter> emitters = new ArrayList<SseEmitter>();

	@GetMapping("/sse")
	public SseEmitter sse() {
		SseEmitter emitter = new SseEmitter();

		// Action a faire quand l'event est complété
		emitter.onCompletion(() -> {
			// Permet d'être sur qu'on est sur une seul liste
			synchronized (this.emitters) {
				this.emitters.remove(emitter);
			}
		});

		// Action à faire quand l'event est en timeout
		emitter.onTimeout(() -> {
			emitter.complete();
		});

		this.emitters.add(emitter);

		return emitter;
	}

}
