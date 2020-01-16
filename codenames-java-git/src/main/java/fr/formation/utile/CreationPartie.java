package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Application;
import fr.formation.dao.IDAOPartie;
import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

@Service
public class CreationPartie extends VariableCreationPartie{
	@Autowired
	private IDAOPartie daoPartie;
	
//	private List<Carte> listeCartes = new ArrayList<Carte>();
//	private List<Joueur> listeJoueurs = new ArrayList<Joueur>();

//	public List<Carte> getListeCartes() {
//		return listeCartes;
//	}
//
//	public void setListeCartes(List<Carte> listeCartes) {
//		this.listeCartes = listeCartes;
//	}
//
//	public List<Joueur> getListeJoueurs() {
//		return listeJoueurs;
//	}
//
//	public void setListeJoueurs(List<Joueur> listeJoueurs) {
//		this.listeJoueurs = listeJoueurs;
//	}

//	public void setupPartie(int id) {
//		CreationGrille cGrille = new CreationGrille();
//		CreationEquipe cEquipe = new CreationEquipe();
//		
//		cGrille.setupGrille();
////		listeCartes = cGrille.getMesCartes();
//		cEquipe.setupEquipe(id);
////		listeJoueurs = cEquipe.getJoueurs();
//	}
	
//	public void setupPartie(int id) {
//	CreationGrille cGrille = new CreationGrille();
//	CreationEquipe cEquipe = new CreationEquipe();
//	
//	cGrille.setupGrille();
////	listeCartes = cGrille.getMesCartes();
//	
//	Partie partie = new Partie();
//	for(Joueur j : partie.getMesJoueurs()) {
//		cEquipe.setupEquipe(j.getId());
//	}
	
	
//	listeJoueurs = cEquipe.getJoueurs();
//}
	
	public void verificationPartie(int id) {
		Partie partie = new Partie();
		try {
			partie = daoPartie.findById(id).orElseThrow(Exception::new);
		}catch(Exception e){
			System.out.println("ERREUR CreationPartie.verificationPartie() : n'arrive pas à trouver le joueur");
		}
		
		int compteurBleu = 0;
		int compteurRouge = 0;
		
		int compteurMaitreBleu = 0;
		int compteurMaitreRouge = 0;
		
		//partie.countByMesJoueursCouleur("Bleu");
		
		for(Joueur j : partie.getMesJoueurs()) {
			if(j.getCouleur().equals("Bleu")) {
				compteurBleu++;
			}else if(j.getCouleur().equals("Rouge")) {
				compteurRouge++;
			}
		}
		
		for(Joueur j : partie.getMesJoueurs()) {
			if(j.getRole().equals("Maitre") && j.getCouleur().equals("Bleu")) {
				compteurMaitreBleu++;
			}else if(j.getRole().equals("Maitre") && j.getCouleur().equals("Rouge")) {
				compteurMaitreRouge++;
			}
		}
		
		if(compteurBleu < 2) {
			System.out.println("Pas assez de joueurs bleu.");
			System.out.println("Suppretion de la partie.");
			daoPartie.delete(partie);		
			
		}else if(compteurRouge < 2) {
			System.out.println("Pas assez de joueurs rouge.");
			System.out.println("Suppretion de la partie.");
			daoPartie.delete(partie);
		}else if(compteurMaitreBleu > 1) {
			System.out.println("Trop de maître agent bleu.");
			System.out.println("Suppretion de la partie.");
			daoPartie.delete(partie);
		}else if(compteurMaitreRouge > 1) {
			System.out.println("Trop de maître agent rouge.");
			System.out.println("Suppretion de la partie.");
			daoPartie.delete(partie);
		}
	}

}
