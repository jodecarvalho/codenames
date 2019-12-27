package fr.formation.utile;

import java.util.ArrayList;
import java.util.List;

import fr.formation.dao.hibernate.DAOMotHibernate;
import fr.formation.model.Carte;
import fr.formation.model.Grille;

public class CreationGrille {
	
	private Grille grille = new Grille();
	private List<Carte> mesCartes = new ArrayList<Carte>();
	
	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public List<Carte> getMesCartes() {
		return mesCartes;
	}

	public void setMesCartes(List<Carte> mesCartes) {
		this.mesCartes = mesCartes;
	}
	
	public void setupGrille() {
		this.setupListMot();
		this.setupPositionMot();
		this.setupCouleurMot();
		this.setupDecouvertMot();
	}

	public void setupListMot() {

		for (int i = 0; i < 25; i++) {
			Carte maCarte = new Carte();
			DAOMotHibernate mot = new DAOMotHibernate();
			maCarte.getMonMot().setIdRandom();
			maCarte.setMonMot(mot.findById(maCarte.getMonMot().getId()));

			// Vérifie si la carte existe déjà
			boolean b = true;
			while (b) {
				b = false;
				for (int j = 0; j < mesCartes.size(); j++) {
					String motGrille = mesCartes.get(j).getMonMot().getMot();
					String newMot = maCarte.getMonMot().getMot();
					if (motGrille.equals(newMot)) {
						maCarte.getMonMot().setIdRandom();
						maCarte.setMonMot(mot.findById(maCarte.getMonMot().getId()));
						b = true;
					}
				}
			}

			mesCartes.add(maCarte);

		}
	}

	public void setupPositionMot() {
		for (int i = 0; i < 25; i += 5) {
			for (int j = 0; j < 5; j++) {
				if ((i + j) < 25) {// If normalement pas utile mais pas sécurité ....
					mesCartes.get(i + j).setPos_x((int) (i / 5));
					mesCartes.get(i + j).setPos_y(j);
				}
			}
		}
	}

	public void setupCouleurMot() {
		int r = 9;
		int b = 8;
		int n = 1;
		int t = 9;

		int i = 0;
		while ((r + b + n + t) != 0) {
			int c = (int) (Math.random() * 4);

			if (c == 0) {
				if (r != 0) {
					mesCartes.get(i).setCouleur("Rouge");
					r--;
					i++;
				}
			} else if (c == 1) {
				if (b != 0) {
					mesCartes.get(i).setCouleur("Bleu");
					b--;
					i++;
				}
			} else if (c == 2) {
				if (n != 0) {
					mesCartes.get(i).setCouleur("Noir");
					n--;
					i++;
				}
			} else if (c == 3) {
				if (t != 0) {
					mesCartes.get(i).setCouleur("Blanc");
					t--;
					i++;
				}
			} else {

			}

			if (i > 24) {
				break;
			}
		}
	}

	public void setupDecouvertMot() {
		for (int i = 0; i < 25; i++) {
			mesCartes.get(i).setDecouvert(false);
		}
	}

}
