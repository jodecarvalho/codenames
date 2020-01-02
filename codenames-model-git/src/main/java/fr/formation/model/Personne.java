package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity 
@Table(name = "personne")
public class Personne{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PERSONNE")
	private int id;
	
	@Column(name="PSEUDO_PERSONNE",length = 50, nullable = false, unique = true)
	@NotEmpty
	@Size(max = 50)
	private String pseudo;
	
	@Column(name="PASSWORD_PERSONNE",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 50)
	private String password;
	
	@OneToMany(mappedBy = "personne")
	private List<Joueur> joueurs;
	
	public Personne() {};
	
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}


	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}


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
