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
	public String accueil(Model model, HttpSession session) {
		Personne personne = (Personne) session.getAttribute("personne");
		
		List<Partie> parties = daoPartie.findByMesJoueursPersonnePseudo(personne.getPseudo());
		
		if(parties.size() == 0)
		{
			String lesParties = "Les parties PAS OK";
			model.addAttribute("lesParties", lesParties );
		}
		else {
			String lesParties = "Les parties OK";
			model.addAttribute("lesParties", lesParties );		
		}
		
		model.addAttribute("partie", parties);
		
		return "home";
	}

}
