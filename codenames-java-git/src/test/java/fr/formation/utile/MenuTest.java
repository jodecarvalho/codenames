package fr.formation.utile;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.config.JpaConfig;
import fr.formation.dao.IDAOPersonne;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {JpaConfig.class})
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
	
}
