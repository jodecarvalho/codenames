package fr.formation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOCarte;
import fr.formation.dao.IDAOGrille;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Partie;
import fr.formation.model.Views;

@RestController
@RequestMapping("/api/carte")
public class CarteRestController {
	
	@Autowired
	private IDAOCarte daoCarte;
	@Autowired
	private IDAOPartie daoPartie;
	@Autowired
	private IDAOGrille daoGrille;
	
	@GetMapping("/{id}")
	@JsonView(Views.Carte.class)
	public List<Carte> findByIdGET(@PathVariable int id) {
		List<Carte> cartes = daoCarte.findAllByIdPartie(id);
		
//		Partie partie = daoPartie.findById(id).get();
//		Grille grille = daoGrille.findByPartie(partie);
//		List<Carte> cartes = daoCarte.findAllByGrille(grille);
		
//		for(Carte c : cartes){
//			Hibernate.initialize(c.getMonMot());
//		}

		return cartes;
	}

}
