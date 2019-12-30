package fr.formation.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "partie")
public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_PARTIE")
	private int id;
	
	@OneToOne(mappedBy = "partie", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Grille maGrille = new Grille();
	
	@OneToMany(mappedBy = "partie")
	private List<Joueur> mesJoueurs = null;
	
	@Column(name="ETAT_PARTIE",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 100)
	private String etat; //3 �tats possibles: enCours(en cours de jeu), creation(en cours de cr�ation) donc en attente de joueurs, terminee
	
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
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
