package fr.formation.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;
import fr.formation.model.Carte;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(true)
public class IDAOCarteTest {

	@Autowired(required = false)
	private IDAOCarte daoCarte;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Démarrage des test pour IDAOCarteTest");
	}
	
	@Test
	public void testFindAllByIdPartie() {
		try {
			List<Carte> cartes = daoCarte.findAllByIdPartie(1);
			
			assertEquals(25, cartes.size());
			
		}
		catch(Exception e){
			System.out.println("ERREUR");
			fail(e.getMessage());
		}
	}
}
