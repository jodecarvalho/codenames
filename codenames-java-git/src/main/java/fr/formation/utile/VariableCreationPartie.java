package fr.formation.utile;

import java.util.ArrayList;
import java.util.List;

import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

public class VariableCreationPartie {
	protected static List<Carte> cartes = new ArrayList<Carte>();
	protected static List<Joueur> personnes = new ArrayList<Joueur>();
	protected static List<Joueur> joueurs = new ArrayList<Joueur>();
	protected static Grille grille = new Grille();
	protected static Partie partie = new Partie();
	
	public Partie getPartie() {
		return partie;
	}
	public void setPertie(Partie pertie) {
		VariableCreationPartie.partie = pertie;
	}
	public List<Carte> getCartes() {
		return cartes;
	}
	public void setCartes(List<Carte> cartes) {
		VariableCreationPartie.cartes = cartes;
	}
	public List<Joueur> getJoueurs() {
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		VariableCreationPartie.joueurs = joueurs;
	}
	public Grille getGrille() {
		return grille;
	}
	public void setGrille(Grille grille) {
		VariableCreationPartie.grille = grille;
	}
	
	

}
