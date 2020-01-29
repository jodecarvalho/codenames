package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOGrille;
import fr.formation.dao.IDAOMot;
import fr.formation.dao.IDAOPartie;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Mot;
import fr.formation.model.Partie;

@Service
public class CreationGrille extends VariableCreationPartie{
	@Autowired
	private IDAOMot daoMot;
	
	@Autowired
	private IDAOPartie daoPartie;
	
	@Autowired
	private IDAOGrille daoGrille;
//	private Grille grille = new Grille();
//	private List<Carte> cartes = new ArrayList<Carte>();
	
//	public Grille getGrille() {
//		return grille;
//	}
//
//	public void setGrille(Grille grille) {
//		this.grille = grille;
//	}
//
//	public List<Carte> getMesCartes() {
//		return cartes;
//	}
//
//	public void setMesCartes(List<Carte> mesCartes) {
//		this.cartes = mesCartes;
//	}
	
	
	@Transactional
	public void setupGrille() {
		this.setupListMot();
		this.setupPositionMot();
		this.setupCouleurMot();
		this.setupDecouvertMot();
	}
	
	@Transactional
	public void setupListMot() {

		for (int i = 0; i < 25; i++) {
			Carte maCarte = new Carte();
			//DAOMotHibernate daoMot = new DAOMotHibernate();
			try {
				//maCarte.getMonMot().setIdRandom();
				//maCarte.setMonMot(daoMot.findById(maCarte.getMonMot().getId()).orElseThrow(Exception::new));
				maCarte.setMonMot(daoMot.findById((int) (Math.random() * 698)).orElseThrow(Exception::new));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			

			// Vérifie si la carte existe déjà
			boolean b = true;
			while (b) {
				b = false;
				for (int j = 0; j < cartes.size(); j++) {
					String motGrille = cartes.get(j).getMonMot().getMot();
					String newMot = maCarte.getMonMot().getMot();
					try {
						if (motGrille.equals(newMot)) {
//							maCarte.getMonMot().setIdRandom();
//							maCarte.setMonMot(daoMot.findById(maCarte.getMonMot().getId()).orElseThrow(Exception::new));
							maCarte.setMonMot(daoMot.findById((int) (Math.random() * 698)).orElseThrow(Exception::new));
							b = true;
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
			}

			cartes.add(maCarte);

		}
	}
	
	@Transactional
	public void setupPositionMot() {
		for (int i = 0; i < 25; i += 5) {
			for (int j = 0; j < 5; j++) {
				if ((i + j) < 25) {// If normalement pas utile mais pas sécurité ....
					cartes.get(i + j).setPos_x((int) (i / 5));
					cartes.get(i + j).setPos_y(j);
				}
			}
		}
	}
	
	@Transactional
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
					cartes.get(i).setCouleur("Rouge");
					r--;
					i++;
				}
			} else if (c == 1) {
				if (b != 0) {
					cartes.get(i).setCouleur("Bleu");
					b--;
					i++;
				}
			} else if (c == 2) {
				if (n != 0) {
					cartes.get(i).setCouleur("Noir");
					n--;
					i++;
				}
			} else if (c == 3) {
				if (t != 0) {
					cartes.get(i).setCouleur("Blanc");
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
	
	@Transactional
	public void setupDecouvertMot() {
		for (int i = 0; i < 25; i++) {
			cartes.get(i).setDecouvert(false);
		}
	}
	
	@Transactional
	public void saveGrille(int id) {//Sauve la grille dans la partie
		Partie partie = new Partie();
		try {
			partie = daoPartie.findById(id).orElseThrow(Exception::new);
		}catch(Exception e){
			System.out.println("ERREUR CreationGrille.saveGrille : n'arrive pas à trouver la partie");
		}
		
		Grille grille = new Grille();
		grille.setMesCartes(cartes);
//		daoGrille.save(grille);
		grille.setPartie(partie);
		
		for (Carte c : cartes) {
			c.setGrille(grille);
		}
		
		//On sauvegarde dans la partie pour donner une id à la partie
		daoGrille.save(grille);
		

	}
	
	

}
