package fr.formation;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOPartie;
import fr.formation.model.Partie;
import fr.formation.model.Views;


@RestController
@RequestMapping("/api/partie")
public class PartieRestController {
	@Autowired
	private IDAOPartie daoPartie;
	
	@GetMapping("/{id}")
	@JsonView(Views.Partie.class)
	public Partie findByIdGET(@PathVariable int id) {
		Partie p = daoPartie.findById(id).get();
		
		Hibernate.initialize(p.getMesJoueurs());
		
		return p;
	}
}
