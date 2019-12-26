package fr.formation.model;

public class Carte {
	//Créer une carte 
	private int id;
	private Mot monMot = new Mot();
	//private Type type = null;
	private String couleur;
	private int pos_x;
	private int pos_y;
	private boolean decouvert;
	
//	public void setupMot() {
//		this.monMot.setIdRandom();
//		//this.monMot.setMot(this.monMot.getId());
//		this.monMot = findById(this.monMot.getId());
//	}
	
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