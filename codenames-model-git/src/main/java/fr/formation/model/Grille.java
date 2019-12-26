package fr.formation.model;

import java.util.ArrayList;

public class Grille {
	private ArrayList<Carte> mesCartes = new ArrayList<Carte>();
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

	public ArrayList<Carte> getMesCartes() {
		return mesCartes;
	}
	
	public void setMesCartes(ArrayList<Carte> mesCartes) {
		this.mesCartes = mesCartes;
	}

	public void setMesCartes() {
		// Carte maCarte = new Carte();
		/*
		 * for(int i = 0 ; i<5 ; i++) { for(int j = 0 ; j<5 ; j++) {
		 * this.maGrillesetupMot(); } }
		 */

//		for (int i = 0; i < 25; i++) {
//			Carte maCarte = new Carte();
//			maCarte.setupMot();
//			
//			//Vérifie si la carte existe déjà
//			boolean b = true;
//			while(b) {
//				b=false;
//				for(int j = 0 ; j<mesCartes.size() ; j++) {
//					String motGrille = mesCartes.get(j).getMonMot().getMot();
//					String newMot = maCarte.getMonMot().getMot();
//					if(motGrille.equals(newMot)) {
//						maCarte.setupMot();
//						b=true;
//					}				
//				}
//			}
//			
//			mesCartes.add(maCarte);
//			
//		}

		

		/*for (int i = 0; i < 25; i++) {
			Carte maCarte = new Carte();
			DAOMotSQL motSQL = new DAOMotSQL();
			maCarte.getMonMot().setIdRandom();
			maCarte.setMonMot(motSQL.findById(maCarte.getMonMot().getId())) ;

			// Vérifie si la carte existe déjà
			boolean b = true;
			while (b) {
				b = false;
				for (int j = 0; j < mesCartes.size(); j++) {
					String motGrille = mesCartes.get(j).getMonMot().getMot();
					String newMot = maCarte.getMonMot().getMot();
					if (motGrille.equals(newMot)) {
						maCarte.getMonMot().setIdRandom();
						maCarte.setMonMot(motSQL.findById(maCarte.getMonMot().getId())) ;
						b = true;
					}
				}
			}
			
			

			mesCartes.add(maCarte);

		}*/

	}

	

	// Il faut donner une position à chaque mot
	/*
	 * public void position(ArrayList<Carte> mesCartes) {
	 * 
	 * for(int i = 5 ; i<30 ; i+=5) { for(int j = 0 ; j<5 ; j++) {
	 * mesCartes.get(i+j).setPos_x((i-5)); mesCartes.get(i+j).setPos_y(j); } } }
	 */

}