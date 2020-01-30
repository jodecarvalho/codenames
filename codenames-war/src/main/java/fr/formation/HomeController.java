package fr.formation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOPartie;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@Controller
public class HomeController {
	@Autowired
	private IDAOPartie daoPartie;
	
	@GetMapping("/home")
	public String homeGET(Model model, HttpSession session) {
		Personne personne = (Personne) session.getAttribute("personne");
		
		List<Partie> parties = daoPartie.findByJoueursPersonnePseudo(personne.getPseudo());
		
		model.addAttribute("parties", parties);
		
		return "home";
	}

}
