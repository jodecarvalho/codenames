package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "joueur")
public class Joueur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_JOUEUR")
	private int id;
	
	@Column(name="COULEUR_JOUEUR",length = 10, nullable = true)
	@Size(max = 10)
	private String couleur;
	
	@Column(name="ROLE_JOUEUR",length = 50, nullable = true)
	@Size(max = 50)
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERSONNE_JOUEUR")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn(name = "ID_PARTIE_JOUEUR")
	private Partie partie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public Personne getPersonne() {
		return personne;
	}
	
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	public Partie getPartie() {
		return partie;
	}
	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
	
}
