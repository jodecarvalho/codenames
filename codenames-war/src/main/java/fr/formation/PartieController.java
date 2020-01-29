package fr.formation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Partie;
import fr.formation.model.Personne;
import fr.formation.utile.CreationGrille;
import fr.formation.utile.MenuCreationPartie;

@Controller
public class PartieController {
	@Autowired
	IDAOPartie daoPartie;

	@Autowired
	IDAOPersonne daoPersonne;

	@Autowired
	CreationGrille creationGrille;

	@Autowired
	MenuCreationPartie menuCreationPartie;

	@GetMapping("/creationpartie")
	public String creationPartieGET(@RequestParam int idPersonne, Model model) {

		try {
			Personne personne = daoPersonne.findById(idPersonne).orElseThrow(Exception::new);
			int idPartie = menuCreationPartie.setPartie(personne);// Sauvegarde une partie avec l'id de la personne
			creationGrille.setupGrille();
			creationGrille.saveGrille(idPartie);// sauve la grille poru l'id de la partie

			Partie partie = daoPartie.findById(idPartie).orElseThrow(Exception::new);

			model.addAttribute("partie", partie);// On envoie la partie au model pour ensuite récupérer la grille
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "creationpartie";
	}

}
