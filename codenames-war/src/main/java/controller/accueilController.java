package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class accueilController {
	
	//@RequestMapping("/accueil")
	@GetMapping("/accueil")
	public String acceuil() {
		return "acceuil";
	}

}
