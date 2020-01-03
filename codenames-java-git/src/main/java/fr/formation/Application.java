package fr.formation;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import fr.formation.config.AppConfig;
//import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
//import fr.formation.dao.hibernate.DAOConnectionHibernate;
//import fr.formation.dao.hibernate.DAOPartieHibernate;
//import fr.formation.dao.hibernate.DAOPersonneHibernate;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;
import fr.formation.utile.CreationEquipe;
import fr.formation.utile.CreationPartie;

import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Personne;
import fr.formation.utile.Menu;


@Component
public class Application {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Persistence.createEntityManagerFactory("NomPersistenceUnit");
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		myContext.getBean("application", Application.class).run(args);
		myContext.close();
		//
	}
	
	public void run(String[] args) {
		boolean chiffre = false;
		Menu menu = new Menu();
		Personne connexionPersonne = new Personne();
		while(chiffre == false) {
			try {
				connexionPersonne = menu.lancementJeu();
				chiffre = true;
			} catch (LireChiffreFormatException e) {
				System.out.println("Veuillez saisir un chiffre");
				System.out.println("");
			}
		}
	}
	
	public void run(String[] args) {
		
	}

}
