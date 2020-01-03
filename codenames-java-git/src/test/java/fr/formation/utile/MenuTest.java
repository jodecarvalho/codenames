package fr.formation.utile;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Personne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(true)
public class MenuTest {

	@Autowired(required = false)
	private IDAOPersonne daoPersonne;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Démarrage des test pour MenuTest");
	}
	
	@Test
	public void testInscriptionPersonne() {
		Personne personne = new Personne();
		personne.setPseudo("yes");
		personne.setPassword("oui");
		try {
			daoPersonne.save(personne);
		}
		catch(Exception e) {
			fail();
		}
		Personne oui = new Personne();
		oui.setPseudo("oui");
		oui.setPassword("crayon");
		try {
			daoPersonne.save(oui);
			fail();
		}
		catch(Exception e) {}
	}
	
	@Test
	public void testReconnexionPersonne() {
		String vrai = "oui";
		String faux = "faux";
		assertTrue(daoPersonne.findByPseudo(vrai).isPresent());
		assertFalse(daoPersonne.findByPseudo(faux).isPresent());
		Personne jean_vrai = new Personne();
		jean_vrai.setPseudo(vrai);
		jean_vrai.setPassword(vrai);
		assertTrue(vrai.equals(jean_vrai.getPassword()));
		assertFalse(faux.equals(jean_vrai.getPassword()));
	}
}
