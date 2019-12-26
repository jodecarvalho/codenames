package fr.formation.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOConnectionHibernate {
	protected static EntityManagerFactory emf = null;//static pour que emf soit le m^me partout
	protected EntityManager em = null;
	
	public DAOConnectionHibernate() {
		this.setup();
	}
	
	public void setup() {
		if(emf == null) {//Création de EMF si non existant
			emf = Persistence.createEntityManagerFactory("NomPersistenceUnit");
		}
		
		if(emf != null) {//Création de EM pour chaque instance
			em = emf.createEntityManager();
		}
	}
	
	public static void close() {
		if(emf != null) {
			emf.close();
			emf = null;
		}
	}

}
