package fr.formation.model;

public class Joueur extends Personne {
	//Cr�� un joueur � partir d'une personne
	//
	private Type couleur;
	private Role role;
	
	public Type getCouleur() {
		return couleur;
	}
	public void setCouleur(Type couleur) {
		this.couleur = couleur;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
