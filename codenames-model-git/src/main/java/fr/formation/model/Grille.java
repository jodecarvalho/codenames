package fr.formation.model;
import java.util.List;

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
@Table(name = "grille")
public class Grille {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_GRILLE")
	private int id;

	@OneToMany(mappedBy = "grille")
	private List<Carte> mesCartes = null;
	
	@OneToOne
	@JoinColumn(name = "ID_PARTIE_GRILLE")
	private Partie partie;
	// private Carte maGrille[][] = new Carte[5][5];
	// private Carte maCarte = null;

	/*
	 * public ArrayList<Carte> getMesCartes() { return mesCartes; }
	 * 
	 * public void setMesCartes(ArrayList<Carte> mesCartes) { for(int i = 0; i <25;
	 * i++) {
	 * 
	 * } this.mesCartes = mesCartes; }
	 */

	public int getId() {
		return id;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<Carte> getMesCartes() {
		return mesCartes;
	}
	
	public void setMesCartes(List<Carte> mesCartes) {
		this.mesCartes = mesCartes;
	

//	public void setupCartes() {
//
//		// Carte maCarte = new Carte();
//		/*
//		 * for(int i = 0 ; i<5 ; i++) { for(int j = 0 ; j<5 ; j++) {
//		 * this.maGrillesetupMot(); } }
//		 */
//
////		for (int i = 0; i < 25; i++) {
////			Carte maCarte = new Carte();
////			maCarte.setupMot();
////			
////			//Vérifie si la carte existe déjà
////			boolean b = true;
////			while(b) {
////				b=false;
////				for(int j = 0 ; j<mesCartes.size() ; j++) {
////					String motGrille = mesCartes.get(j).getMonMot().getMot();
////					String newMot = maCarte.getMonMot().getMot();
////					if(motGrille.equals(newMot)) {
////						maCarte.setupMot();
////						b=true;
////					}				
////				}
////			}
////			
////			mesCartes.add(maCarte);
////			
////		}
//
//		
//
//		for (int i = 0; i < 25; i++) {
//			Carte maCarte = new Carte();
//			DAOMotHibernate motSQL = new DAOMotSQL();
//			maCarte.getMonMot().setIdRandom();
//			maCarte.setMonMot(motSQL.findById(maCarte.getMonMot().getId())) ;
//
//			// Vérifie si la carte existe déjà
//			boolean b = true;
//			while (b) {
//				b = false;
//				for (int j = 0; j < mesCartes.size(); j++) {
//					String motGrille = mesCartes.get(j).getMonMot().getMot();
//					String newMot = maCarte.getMonMot().getMot();
//					if (motGrille.equals(newMot)) {
//						maCarte.getMonMot().setIdRandom();
//						maCarte.setMonMot(motSQL.findById(maCarte.getMonMot().getId())) ;
//						b = true;
//					}
//				}
//			}
//			
//			
//
//			mesCartes.add(maCarte);
<<<<<<< Updated upstream
//
//		}
=======

		}
>>>>>>> Stashed changes
//
//	}

	

	// Il faut donner une position à chaque mot
	/*
	 * public void position(ArrayList<Carte> mesCartes) {
	 * 
	 * for(int i = 5 ; i<30 ; i+=5) { for(int j = 0 ; j<5 ; j++) {
	 * mesCartes.get(i+j).setPos_x((i-5)); mesCartes.get(i+j).setPos_y(j); } } }
	 */

}