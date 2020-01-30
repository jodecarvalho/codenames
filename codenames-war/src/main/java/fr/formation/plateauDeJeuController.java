package fr.formation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class plateauDeJeuController {

	@GetMapping("/partieEnCours")
	public String affichagePlateauGet() {
		return "plateauDeJeu";
	}
	
	@GetMapping("/agentRouge")
	public String plateauAgentRougeGET() {
		return "plateauAgentRouge";
	}
	
	@GetMapping("/agentBleu")
	public String plateauAgentBleuGET() {
		return "plateauAgentBleu";
	}
}
