package fr.formation.model;

public class Joueur extends Personne {
	//Cr�� un joueur � partir d'une personne
	//
	private String couleur;
	private String role;
	
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
