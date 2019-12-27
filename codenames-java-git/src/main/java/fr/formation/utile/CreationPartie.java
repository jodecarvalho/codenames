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

public class CreationPartie {
	private CreationGrille cGrille = new CreationGrille();
	private CreationEquipe cEquipe = new CreationEquipe();
	private List<Carte> listeCartes = new ArrayList<Carte>();
	private List<Joueur> listeJoueurs = new ArrayList<Joueur>();

	public CreationGrille getcGrille() {
		return cGrille;
	}

	public void setcGrille(CreationGrille cGrille) {
		this.cGrille = cGrille;
	}

	public CreationEquipe getcEquipe() {
		return cEquipe;
	}

	public void setcEquipe(CreationEquipe cEquipe) {
		this.cEquipe = cEquipe;
	}

	public List<Carte> getListeCartes() {
		return listeCartes;
	}

	public void setListeCartes(List<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}

	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}

	public void setupPartie(List<Personne> personnes) {
		cGrille.setupGrille();
		listeCartes = cGrille.getMesCartes();
		cEquipe.setupEquipe(personnes);
		listeJoueurs = cEquipe.getJoueurs();
	}

}
