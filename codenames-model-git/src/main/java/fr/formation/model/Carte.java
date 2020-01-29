package fr.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;

@Entity 
@Table(name = "carte")
public class Carte {
	//Créer une carte 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_CARTE")
	@JsonView(Views.Common.class)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "ID_MOT_CARTE")
	@JsonView({Views.Carte.class, Views.MotFetchingCarte.class})
	private Mot monMot;
	
	@Column(name="COULEUR_CARTE",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 50)
	@JsonView(Views.Carte.class)
	private String couleur;
	
	@Column(name = "POSITION_X_CARTE", nullable = false)
//	@NotEmpty
	@JsonView(Views.Carte.class)
	private int pos_x;
	
	@Column(name = "POSITION_Y_CARTE", nullable = false)
//	@NotEmpty
	@JsonView(Views.Carte.class)
	private int pos_y;
	
	@Column(name = "DECOUVERT")
	@JsonView(Views.Carte.class)
	private boolean decouvert;
	
	@ManyToOne
	@JoinColumn(name = "ID_GRILLE_CARTE")
	@JsonView({Views.Carte.class, Views.GrilleFetchingCarte.class})
	private Grille grille;
	
//	public void setupMot() {
//		this.monMot.setIdRandom();
//		//this.monMot.setMot(this.monMot.getId());
//		this.monMot = findById(this.monMot.getId());
//	}
	
	public Grille getGrille() {
		return grille;
	}
	public void setGrille(Grille grille) {
		this.grille = grille;
	}
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
	
	public Mot getMonMot() {
		return monMot;
	}
	public void setMonMot(Mot monMot) {
		this.monMot = monMot;
	}
//	public Type getType() {
//		return type;
//	}
//	public void setType(Type type) {
//		this.type = type;
//	}
	public boolean isDecouvert() {
		return decouvert;
	}
	public void setDecouvert(boolean decouvert) {
		this.decouvert = decouvert;
	}
	public int getPos_x() {
		return pos_x;
	}
	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}
	public int getPos_y() {
		return pos_y;
	}
	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}
	
	
	
}