package fr.formation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class plateauDeJeuController {

	@GetMapping("/partieEnCours")
	public String affichagePlateauGet() {
		return "plateauDeJeu";
	}
	
	@GetMapping("/AgentRouge")
	public String plateauAgentRougeGET() {
		return "plateauAgentRouge";
	}
}
