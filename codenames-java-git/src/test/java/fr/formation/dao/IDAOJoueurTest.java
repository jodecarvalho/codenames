package fr.formation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(true)
public class IDAOJoueurTest {
	@Autowired
	IDAOJoueur daoJoueur;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Démarrage des test pour IDAOPartieTest");
	}
	
	@Test
	public void testFindByPartieId() {
		try {
			List<Joueur> joueurs = daoJoueur.findByPartieId(1);
			
			for(Joueur j : joueurs){
				System.out.println(j.getCouleur());
				System.out.println(j.getPersonne().getPseudo());
			}
			
		}catch(Exception e) {
			System.out.println("ERREUR");
			fail(e.getMessage());
		}
		
	}

}
