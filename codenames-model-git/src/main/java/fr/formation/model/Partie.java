package fr.formation.model;

import java.util.ArrayList;

public class Partie {
	private int id;
	private Grille maGrille = new Grille();
	private ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public Grille getMaGrille() {
		return maGrille;
	}
	public void setMaGrille(Grille maGrille) {
		this.maGrille = maGrille;
	}
	public ArrayList<Joueur> getMesJoueurs() {
		return mesJoueurs;
	}
	public void setMesJoueurs(ArrayList<Joueur> mesJoueurs) {
		this.mesJoueurs = mesJoueurs;
	}
}
