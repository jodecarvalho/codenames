package fr.formation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import fr.formation.model.Carte;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/plateauDeJeu")
public class plateauDeJeuRestController {

	private List<SseEmitter> emitters = new ArrayList<SseEmitter>();
	private List<SseEmitter> emittersTuiles = new ArrayList<SseEmitter>();
	
	@PostMapping
	public String ping(@RequestBody String string) {
		System.out.println(string);
		
		for (SseEmitter emitter: this.emitters) {
			try {
				emitter.send("Un joueur est prêt");
			}
			catch(Exception ex) {
				emitter.completeWithError(ex);
			}
		}
		return string;
	}
	
	@GetMapping("/sse")
	public SseEmitter sse() {
		SseEmitter emitter = new SseEmitter();
		
		//Actions à faire quand l'Event est complété
		emitter.onCompletion(() -> {
			synchronized (this.emitters) {
				//PERMET D ETRE SUR QU ON EST SEUL A UTILISER LA LISTE
				this.emitters.remove(emitter);
			}
		});
		
		//Actions à faire quand l'Event est en Timeout
		emitter.onTimeout(() -> {
			emitter.complete();
		});
		
		this.emitters.add(emitter);
		
		return emitter;
	}
	
	@PostMapping("/envoiTuile")
	public List<Carte> envoiTuile(@RequestBody List<Carte> cartes) {
		
		for (SseEmitter emitter: this.emittersTuiles) {
			try {
				emitter.send("Une tuile a été retournée");
			}
			catch(Exception ex) {
				emitter.completeWithError(ex);
			}
		}
		return cartes;
	}
	
	@GetMapping("/sse2")
	public SseEmitter sse2() {
		SseEmitter emitter = new SseEmitter();
		
		//Actions à faire quand l'Event est complété
		emitter.onCompletion(() -> {
			synchronized (this.emittersTuiles) {
				//PERMET D ETRE SUR QU ON EST SEUL A UTILISER LA LISTE
				this.emittersTuiles.remove(emitter);
			}
		});
		
		//Actions à faire quand l'Event est en Timeout
		emitter.onTimeout(() -> {
			emitter.complete();
		});
		
		this.emittersTuiles.add(emitter);
		
		return emitter;
	}
}
