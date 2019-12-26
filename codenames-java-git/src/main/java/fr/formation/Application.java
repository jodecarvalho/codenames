package fr.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
	
	//public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("NomPersistenceUnit");
	}

}
