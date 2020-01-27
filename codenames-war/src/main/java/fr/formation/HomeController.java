package fr.formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOPartie;

@Controller
public class HomeController {
	@Autowired
	private IDAOPartie daoPartie;
	
	@GetMapping("/home")
	public String accueil(Model model) {
		model.addAttribute("parties", daoPartie.findAll());
		return "home";
	}

}
