package fr.formation.utile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback
public class MenuCreationPartieTest {
	@Autowired(required = false)
	private IDAOPartie daoPartie;
	
	private MenuCreationPartie creationPartie = new MenuCreationPartie();
	
	@Test
	public void testDaoProduitExists() {
		assertNotNull(daoPartie);
	}
	
	@Test
	public void testCreationPartieExists() {
		assertNotNull(creationPartie);
	}
	
	@Test
	public void testSetPartie() {
		try {
			Personne personne = new Personne();
			personne.setPseudo("PseudoTest");
			personne.setPassword("PasswordTest");
			assertNotNull(personne);
			
			Joueur createurJoueur = new Joueur();
			createurJoueur.setPersonne(personne);
			assertNotNull(createurJoueur);			
			
			List<Joueur> joueurs = new ArrayList<Joueur>();
			int taille = joueurs.size();
			joueurs.add(createurJoueur);
			assertNotEquals(taille, joueurs.size());
			assertNotNull(createurJoueur);	
			
			Partie partie = new Partie();
			partie.setMesJoueurs(joueurs);
			partie.setEtat("creation");
			assertNotNull(partie);
			assertEquals(partie.getEtat(), "creation");
			
			Partie partieSave = new Partie();
			partieSave = daoPartie.save(partie);
			assertNotNull(partieSave);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAttenteJoueurs() {
		Partie partie = new Partie();
		partie.setEtat("creation");
		assertNotNull(partie);
		assertEquals(partie.getEtat(), "creation");
		
		Partie partieSave = new Partie();
		partieSave = daoPartie.save(partie);
		assertNotNull(partieSave);
		
		int a = 2;
		try {
			if(a == 0) {
				Partie partie2 = new Partie();
				partie2 = daoPartie.findById(partieSave.getId()).orElseThrow(InputMismatchException::new);
				partie2.setEtat("enCours");
				assertNotNull(partie2);
				assertEquals(partie.getEtat(), "enCours");
				assertNotNull(daoPartie.save(partie2));
			}
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		a = 0;
		
		try {
			if(a == 0) {
				Partie partie2 = new Partie();
				partie2 = daoPartie.findById(partieSave.getId()).orElseThrow(InputMismatchException::new);
				partie2.setEtat("enCours");
				assertNotNull(partie2);
				assertEquals(partie.getEtat(), "enCours");
				assertNotNull(daoPartie.save(partie2));
			}
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
