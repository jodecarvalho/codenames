package fr.formation.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AppConfig.class})
@Transactional
@Rollback(true)
public class IDAOPersonneTest {

	@Autowired(required = false)
	private IDAOPersonne daoPersonne;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Démarrage des test pour IDAOersonneTest");
	}
	
	@Test
	public void testFindByPseudoPersonne() {
		try {
			assertTrue(daoPersonne.findByPseudo("oui").isPresent());
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}
	
}
