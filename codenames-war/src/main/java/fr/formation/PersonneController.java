package fr.formation;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Personne;

@Controller
public class PersonneController {
	@Autowired
	private IDAOPersonne daoPersonne;

	// Connexion joueur
	@GetMapping("/connexion")
	public String connexionGET() {
		return "connexion";
	}

	@PostMapping("/connexion")
	public String connexionPOST(@Valid @ModelAttribute Personne personne, BindingResult result, HttpSession session) {
		// Si il y a des erreurs (speudo et password vide)
		if (result.hasErrors()) {
			return "connexion";
		}

		// Condition if pour vérifier si speudo et password existe dans la base de
		// données => voir plus tard
		
		session.setAttribute("pseudo", personne.getPseudo());
		return "redirect:/home";
	}

	// Inscription joueur
	@GetMapping("/inscription")
	public String inscriptionGET() {
		return "inscription";
	}

	@PostMapping("/inscription")
	public String inscriptionPOST(@Valid @ModelAttribute Personne personne, BindingResult result, HttpSession session) {

		// Si il y a des erreurs (speudo et password vide)
		if (result.hasErrors()) {
			return "inscription";
		}
		
		//Vérifier si le speudo existe déjà
		try {
			daoPersonne.save(personne);
			session.setAttribute("pseudo", personne.getPseudo());
			return "redirect:/home";
		}catch(Exception e) {
			return "inscription";
		}
	}

}
