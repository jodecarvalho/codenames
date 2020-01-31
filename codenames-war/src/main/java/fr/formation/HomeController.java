package fr.formation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOCarte;
import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Carte;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@Controller
public class HomeController {
	@Autowired
	private IDAOPartie daoPartie;
	
	@Autowired
	private IDAOCarte daoCarte;
	
	@Autowired
	private IDAOJoueur daoJoueur;
	
	@GetMapping("/home")
	public String homeGET(Model model, HttpSession session) {
		Personne personne = (Personne) session.getAttribute("personne");
		
		//A essayer si temps
		//List<Carte> cartes = (List<Carte>) session.getAttribute("cartes");
		//List<Joueur> joueurs = (List<Joueur>) session.getAttribute("joueurs");
		//model.addAttribute("cartes", cartes);
		//model.addAttribute("joueurs", joueurs);
		
		
		List<Partie> parties = daoPartie.findByJoueursPersonnePseudo(personne.getPseudo());
		List<Partie> partiesAll = daoPartie.findAll();//Crer method qui ignore la personne et prend que les personne ne creation
		
		model.addAttribute("parties", parties);
		model.addAttribute("partiesAll", partiesAll);
		
		return "home";
	}
	
	@GetMapping("/listeJoueursCartesPartie")
	public String listeJoueursCartesPartieGET(Model model, @RequestParam int id) {
		
		List<Carte> cartes = daoCarte.findAllByIdPartie(id);
		List<Joueur> joueurs = daoJoueur.findByPartieId(id);
		
		//A essayer si temps
		//session.setAttribute("cartes", cartes);
		//session.setAttribute("joueurs", joueurs);
		//return "redirect:/home";
		
		model.addAttribute("cartes", cartes);
		model.addAttribute("joueurs", joueurs);
		
		
		return "listeJoueursCartesPartie";
	}

}
