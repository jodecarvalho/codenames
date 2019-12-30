package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import fr.formation.Application;
import fr.formation.dao.IDAO;
import fr.formation.dao.hibernate.DAOMotHibernate;
import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;

public class CreationPartie extends VariableCreationPartie{
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

	public void setupPartie(List<Personne> personnes) {
		CreationGrille cGrille = new CreationGrille();
		CreationEquipe cEquipe = new CreationEquipe();
		
		cGrille.setupGrille();
//		listeCartes = cGrille.getMesCartes();
		cEquipe.setupEquipe(personnes);
//		listeJoueurs = cEquipe.getJoueurs();
	}

}
