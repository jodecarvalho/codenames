package fr.formation;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;
import fr.formation.utile.CreationGrille;
import fr.formation.utile.MenuCreationPartie;

@Controller
public class PartieController {
	@Autowired
	IDAOPartie daoPartie;
	
	@Autowired
	IDAOJoueur daoJoueur;

	@Autowired
	IDAOPersonne daoPersonne;

	@Autowired
	CreationGrille creationGrille;

	@Autowired
	MenuCreationPartie menuCreationPartie;

	@GetMapping("/creationpartie")
	public String creationPartieGET(@RequestParam int idPersonne, Model model) {

		try {
			Personne personne = daoPersonne.findById(idPersonne).get();
			int idPartie = menuCreationPartie.setPartie(personne);// Sauvegarde une partie avec l'id de la personne
			creationGrille.setupGrille();
			creationGrille.saveGrille(idPartie);// sauve la grille poru l'id de la partie

			Partie partie = daoPartie.findById(idPartie).get();
			List<Joueur> joueurs = daoJoueur.findByPartieId(partie.getId());

			model.addAttribute("partie", partie);// On envoie la partie au model pour ensuite récupérer la grille
			model.addAttribute("joueurs", joueurs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "creationpartie";
	}
	
	@GetMapping("/rejoindrePartie")
	public String rejoindrePartieGET(@RequestParam int idPartie, Model model, HttpSession session) {
		Joueur joueur = new Joueur();
		joueur.setPersonne((Personne) session.getAttribute("personne"));
		joueur.setPartie(daoPartie.findById(idPartie).get());
		daoJoueur.save(joueur);
		
		session.setAttribute("joueur", joueur);
		
		return "rejoindrePartie";
	}
	
//	@PostMapping("/rejoindrePartie")
//	public String rejoindrePartiePOST(@Valid @ModelAttribute Joueur joueur, BindingResult result, HttpSession session) {
//		Personne personne = (Personne) session.getAttribute("personne");
//		joueur.setPersonne(personne);
//		
//		int id = (int) session.getAttribute("idPartie");
//		Partie partie = daoPartie.findById(id).get();
//		joueur.setPartie(partie);
//		
//		daoJoueur.save(joueur);
//		return "redirect:/creationpartie";
//	}

}
