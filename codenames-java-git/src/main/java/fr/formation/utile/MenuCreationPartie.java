package fr.formation.utile;

import java.util.ArrayList;
import java.util.List;

import fr.formation.Application;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.hibernate.DAOPartieHibernate;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

public class MenuCreationPartie {
	
	public int setPartie(Personne personne) {
		System.out.println("Création d'une partie avec votre identifiant");
		IDAOPartie daoPartie = new DAOPartieHibernate();
				
		Joueur createurJoueur = new Joueur();
		createurJoueur.setPersonne(personne);

		Partie partie = new Partie();
		Partie partieSave = new Partie();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(createurJoueur);
		partie.setMesJoueurs(joueurs);
		partie.setEtat("creation");
		partieSave = daoPartie.save(partie);
		return partieSave.getId();
	}
	
	public void attenteJoueurs(int id) {
		System.out.println("Attente de joueurs (taper 0 pour arrêter");
		IDAOPartie daoPartie = new DAOPartieHibernate();
		
		while(true) {
			int a = Application.sc.nextInt();
			if(a == 0) {
				Partie partie = new Partie();
				partie = daoPartie.findById(id);
				partie.setEtat("enCours");
				daoPartie.save(partie);
				break;
			}
		}
		
		
	}

}
