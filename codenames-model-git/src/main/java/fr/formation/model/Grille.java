package fr.formation.model;

import java.util.ArrayList;

public class Grille {
	//ArrayList<Carte> mesCartes = new ArrayList<Carte>();
	private Carte maGrille[][] = new Carte[5][5];
	private Mot monMot = null;
	
	/*public ArrayList<Carte> getMesCartes() {
		return mesCartes;
	}

	public void setMesCartes(ArrayList<Carte> mesCartes) {
		for(int i = 0; i <25; i++) {
			
		}
		this.mesCartes = mesCartes;
	}*/
	
	public Carte[][] getMaGrille() {
		return maGrille;
	}

	public void setMaGrille(Carte[][] maGrille) {
		Carte maCarte = new Carte();
		for(int i = 5 ; i<5 ; i++) {
			for(int j = 0 ; j<5 ; j++) {
				maGrille[i][j] = maCarte.setupCarte();
			}
		}
		
		this.maGrille = maGrille;
	}
	
	public Carte setupCarte() {
		this.monMot.setMot(this.monMot.getId());
		return
	}

	
	//Il faut donner une position à chaque mot
		/*public void position(ArrayList<Carte> mesCartes) {
			
			for(int i = 5 ; i<30 ; i+=5) {
				for(int j = 0 ; j<5 ; j++) {
					mesCartes.get(i+j).setPos_x((i-5));
					mesCartes.get(i+j).setPos_y(j);
				}
			}
		}*/

		
	
	
	

}
