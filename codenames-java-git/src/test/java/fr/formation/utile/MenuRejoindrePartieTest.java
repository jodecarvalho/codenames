package fr.formation.utile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.Application;
import fr.formation.config.AppConfig;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback
public class MenuRejoindrePartieTest {
	@Autowired(required = false)
	private IDAOPartie daoPartie;
	
	private MenuRejoindrePartie rejoindrePartie = new MenuRejoindrePartie();
	
	@Test
	public void testDaoProduitExists() {
		assertNotNull(daoPartie);
	}
	
	@Test
	public void testRejoindrePartieExists() {
		assertNotNull(rejoindrePartie);
	}
	
	@Test
	public void testRejoindrePartie() {
		List<Partie> parties = new ArrayList<Partie>();
		assertNotNull(parties);
		int taille = parties.size();
		
		try {
			parties = daoPartie.findByEtat("enCours");
			assertNotNull(parties);
			assertNotEquals(taille, parties.size());				
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
		int id = 0;
		Personne personne = new Personne();
		personne.setPseudo("PseudoTest");
		personne.setPassword("PasswordTest");
		assertNotNull(personne);
		
		try {
			if(daoPartie.findById(id) != null) {//Si il trouve une partie
				//Enregistrer la personne pour la partie
				Joueur nouveauJoueur = new Joueur();
				nouveauJoueur.setPersonne(personne);
				assertNotNull(nouveauJoueur);
				assertEquals(nouveauJoueur.getPersonne().getPseudo(), "PseudoTest");
				assertEquals(nouveauJoueur.getPersonne().getPassword(), "PasswordTest");
				
				Partie partie = new Partie();
				partie = daoPartie.findById(id).orElseThrow(Exception::new);
				assertNotNull(partie);
				
				List<Joueur> joueurs = new ArrayList<Joueur>();
				
				taille = joueurs.size();
				
				joueurs.addAll(partie.getMesJoueurs());
				joueurs.add(nouveauJoueur);
				partie.setMesJoueurs(joueurs);
				daoPartie.save(partie);
			}
		}catch(Exception e) {
			System.out.println("ERREUR MenuRejoindrePartie.rejoindrePartie()");
		}
		
		
	}

}
