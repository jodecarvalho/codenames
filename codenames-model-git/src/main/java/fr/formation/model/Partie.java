package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "partie")
	private Grille maGrille = new Grille();
	
	@OneToMany(mappedBy = "partie")
	private List<Joueur> mesJoueurs = null;
	
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
	public List<Joueur> getMesJoueurs() {
		return mesJoueurs;
	}
	public void setMesJoueurs(List<Joueur> mesJoueurs) {
		this.mesJoueurs = mesJoueurs;
	}
}
