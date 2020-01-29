package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Application;
import fr.formation.dao.IDAOPartie;
//import fr.formation.dao.hibernate.DAOPartieHibernate;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@Service
public class MenuCreationPartie {
	@Autowired
	private IDAOPartie daoPartie ;
	
	@Transactional
	public int setPartie(Personne personne) {
		System.out.println("Cr�ation d'une partie avec votre identifiant");
		//IDAOPartie daoPartie = new DAOPartieHibernate();
		
		Joueur createurJoueur = new Joueur();
		createurJoueur.setPersonne(personne);//Besoin le metter � cause des join column
		

		List<Joueur> joueurs = new ArrayList<Joueur>();//Voir si il faut laisser ou pas
		joueurs.add(createurJoueur);
		
		
		Partie partie = new Partie();
		partie.setMesJoueurs(joueurs);
		partie.setEtat("creation");
		Partie partieSave = new Partie();
		partieSave = daoPartie.save(partie);//On cr�er une nouvelle partie et on la r�cup�re
		
		createurJoueur.setPartie(partieSave);
		partieSave = daoPartie.save(partie);//on sauvegarde les modifs
		return partieSave.getId();
	}
	
	@Transactional
	public void attenteJoueurs(int id) {
		System.out.println("Attente de joueurs (taper 0 pour arr�ter)");
		//IDAOPartie daoPartie = new DAOPartieHibernate();
		
		while(true) {
			try {
				int a = Application.sc.nextInt();
				if(a == 0) {
					Partie partie = new Partie();
					partie = daoPartie.findById(id).orElseThrow(InputMismatchException::new);
					partie.setEtat("enCours");
					daoPartie.save(partie);
					break;
				}
			}catch(InputMismatchException e) {
				Application.sc.nextLine();
				e.getStackTrace();
				System.out.println("ERREUR MenuCreationPartie.attenteJoueurs()");
			}
		}
	}

}
