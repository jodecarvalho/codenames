package fr.formation.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partie")
public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PARTIE")
	private int id;
	
	@OneToOne
	private Grille maGrille = new Grille();
	
	@OneToMany(mappedBy = "partie")
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
