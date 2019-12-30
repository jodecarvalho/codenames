package fr.formation;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
import fr.formation.dao.hibernate.DAOConnectionHibernate;
import fr.formation.dao.hibernate.DAOPartieHibernate;
import fr.formation.dao.hibernate.DAOPersonneHibernate;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;
import fr.formation.utile.CreationEquipe;
import fr.formation.utile.CreationPartie;

import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Personne;
import fr.formation.utile.Menu;
import fr.formation.utile.VariableCreationPartie;


public class Application {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Persistence.createEntityManagerFactory("NomPersistenceUnit");
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
		
		
//		Grille grille = new Grille();
//		CreationPartie partie = new CreationPartie();
//		
//		partie.setupGrille();
//		grille.setMesCartes(partie.getMesCartes());
//		
//		grille.getMesCartes().forEach(c -> {
//			System.out.print(c.getMonMot().getMot());System.out.print(c.getPos_x());System.out.print(c.getPos_y());
//			System.out.print(c.getCouleur());System.out.println(c.isDecouvert());
//		});
		
//		List<Personne> personnes = new ArrayList<Personne>();
//		Personne personne1 = new Personne();
//		Personne personne2 = new Personne();
//		Personne personne3 = new Personne();
//		Personne personne4 = new Personne();
//		
//		personne1.setPseudo("Joaquim");personne1.setPassword("Pouette");
//		personne2.setPseudo("Camille");personne2.setPassword("CoinCoin");
//		personne3.setPseudo("Thibaud");personne2.setPassword("DocteurPouple");
//		personne4.setPseudo("Michael");personne2.setPassword("Kamate");
//		
//		personnes.add(personne1);
//		personnes.add(personne2);
//		personnes.add(personne3);
//		personnes.add(personne4);
//		
//		CreationEquipe equipe = new CreationEquipe();
//		
//		equipe.setupEquipe(personnes);
//		
//		equipe.getJoueurs().forEach(c -> {
//			System.out.print(c.getPersonne().getPseudo() + " " + c.getCouleur()  + " " + c.getRole());
//		});
//		
//		//Taper 1 pour cr�er une partie
//		Partie partie = new Partie();
//		IDAOPartie daoPartie = new DAOPartieHibernate();
//		daoPartie.save(partie);
//		
//		//Taper 2 pour rejoindre une partie
//		List<Partie> parties = new ArrayList<Partie>();//Find partie en cours de cr�ation
//		IDAOPartie daoPartie = new DOAPartieHibernate
//		
//		//Cr�er la partie
//		CreationPartie cPartie = new CreationPartie();
		
		
		DAOConnectionHibernate.close();


	}

}
