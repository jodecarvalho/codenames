package fr.formation;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.formation.dao.IDAO;
import fr.formation.dao.hibernate.DAOConnectionHibernate;
import fr.formation.dao.hibernate.DAOPersonneHibernate;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;
import fr.formation.utile.CreationPartie;

import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Personne;
import fr.formation.utile.Menu;


public class Application {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean chiffre = false;
		Menu menu = new Menu();
		Personne connexionPersonne = new Personne();
		while(chiffre == false) {
			try {
				connexionPersonne = menu.gameConnection();
				chiffre = true;
			} catch (LireChiffreFormatException e) {
				System.out.println("Veuillez saisir un chiffre");
				System.out.println("");
			}
		}
		Grille grille = new Grille();
		CreationPartie partie = new CreationPartie();
		
		partie.setupGrille();
		grille.setMesCartes(partie.getMesCartes());
		
		grille.getMesCartes().forEach(c -> {
			System.out.print(c.getMonMot().getMot());System.out.print(c.getPos_x());System.out.print(c.getPos_y());
			System.out.print(c.getCouleur());System.out.println(c.isDecouvert());
		});
		
		
		
		DAOConnectionHibernate.close();


	}

}
