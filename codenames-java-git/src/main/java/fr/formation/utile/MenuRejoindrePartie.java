package fr.formation.utile;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Application;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@Service
public class MenuRejoindrePartie {
	@Autowired
	private IDAOPartie daoPartie;
	
	@Transactional
	public void rejoindrePartie(Personne personne) {
		List<Partie> parties = new ArrayList<Partie>();//Find partie en cours de création
		//IDAOPartie daoPartie = new DAOPartieHibernate();
		int id = 0;
		
		try {//Obtient la list des partie que l'on peut rejoindre
			//parties = daoPartie.rejoindrePartie();
			parties = daoPartie.findByEtat("enCours");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur IDAOPartie.rejoindrePartie()");
		}
		
		parties.forEach(p ->{//Affiche la liste des parties
			System.out.println("ID Partie : " + p.getId());
		});
		
		//Selction de la partie
		while(true) {
			System.out.println("Choisir une partie en tapant son ID (0 pour sortir)");
			try {
				id = Application.sc.nextInt();
				if(daoPartie.findById(id) != null) {//Si il trouve une partie
					//Enregistrer la personne pour la partie
					Joueur nouveauJoueur = new Joueur();
					nouveauJoueur.setPersonne(personne);
					Partie partie = new Partie();
					partie = daoPartie.findById(id).orElse(new Partie());
					List<Joueur> joueurs = new ArrayList<Joueur>();
					
					joueurs.addAll(partie.getMesJoueurs());
					joueurs.add(nouveauJoueur);
					partie.setMesJoueurs(joueurs);
					daoPartie.save(partie);
					System.out.println("Enregistré pour la partie " + id);
					break;
				}
				else if(id == 0) {
					id=0;
					break;
				}
				else {
					System.out.println("La partie n'existe pas. Retenter");
				}
			}catch(Exception e) {
				System.out.println("ERREUR MenuRejoindrePartie.rejoindrePartie()");
			}
			
		}
		
	}

}
