package fr.formation.model;
public class Personne{
	//Créer une entité personne
	private int id;
	protected String pseudo;
	protected String password;
	
	public Personne() {};
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
