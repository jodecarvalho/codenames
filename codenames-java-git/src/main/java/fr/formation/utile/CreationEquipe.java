package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Application;
import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;

@Service
public class CreationEquipe extends VariableCreationPartie {
	@Autowired
	IDAOPartie daoPartie;

	@Autowired
	IDAOPersonne daoPersonne;

	@Autowired
	IDAOJoueur daoJoueur;

//	private List<Joueur> joueurs = new ArrayList<Joueur>();
//	
//	public List<Joueur> getJoueurs() {
//		return joueurs;
//	}
//
//	public void setJoueurs(List<Joueur> joueurs) {
//		this.joueurs = joueurs;
//	}

	@Transactional
	public void setupEquipe(int id) {
		/*for (Personne p : personnes) {
			this.setCreationJoueur(p);
		}*/
		// this.setCouleurJoueur();
		//this.setRoleJoueur();
		this.setCouleurJoueur(id);
		this.setRoleJoueur(id);
	}

	/*@Transactional
	public void setCreationJoueur(Personne personne) {
		Joueur joueur = new Joueur();
		joueur.setPersonne(personne);
		joueurs.add(joueur);
	}*/

	@Transactional
	public void setCouleurJoueur(int id) {//Set le role d'un joueur devant son PC

		System.out.println("Choisir l'équipe");
		int compteurBleu = 0;
		int compteurRouge = 0;
		Joueur joueur = new Joueur();

		try {

			joueur = daoJoueur.findById(id).orElseThrow(Exception::new);
		} catch (Exception e) {
			System.out.println("ERREUR CreationEquipe.setCouleurJoueur : n'arrive pas à trouver le joueur");
		}

		while (true) {
			try {
				int a = Application.sc.nextInt();

				if (a == 1) {
					joueur.setCouleur("Bleu");
					System.out.println(joueur.getPersonne().getPseudo() + " a la couleur " + joueur.getCouleur());
					compteurBleu++;
					break;
				} else if (a == 2) {
					joueur.setCouleur("Rouge");
					System.out.println(joueur.getPersonne().getPseudo() + " a la couleur " + joueur.getCouleur());
					compteurRouge++;
					break;
				} else if (a == 0) {
					compteurBleu = 5;// Pour sortir de la boucle
					compteurRouge = 5;
					break;
				} else {
					System.out.println("Veuillez taper l'un des chiffres proposés.");
					System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
							+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
				}

			} catch (InputMismatchException e) {
				Application.sc.nextLine(); // Pour suppr la touche entrée du flux
				System.out.println("On a dit un nombre !");
			}
		}

		//Le joueur a déjà l'ID de la partie donc on n'est pas obliger d'utiliser IDAOPartie
		daoJoueur.save(joueur);

//		while (compteurBleu < 2 || compteurRouge < 2) {
////			if(compteurBleu < 2 || compteurRouge < 2) {
////				compteurBleu = 0;
////				compteurRouge = 0;
////			}			
//			
//			for (int i = 0; i<joueurs.size();i++) {
//				
//				System.out.println("Personne " + joueurs.get(i).getPersonne().getPseudo() + " choisissez votre couleur");
//				System.out.println("Taper 1 pour bleu, 2 pour rouge");
//
//				boolean b = true;
//
//				while (b) {
//					try {
//						int a = Application.sc.nextInt();
//
//						if (a == 1) {
//							joueurs.get(i).setCouleur("Bleu");
//							System.out.println(joueurs.get(i).getPersonne().getPseudo() + " a la couleur " + joueurs.get(i).getCouleur());
//							compteurBleu++;
//							b = false;
//						} else if (a == 2) {
//							this.joueurs.get(i).setCouleur("Rouge");
//							System.out.println(joueurs.get(i).getPersonne().getPseudo() + " a la couleur " + joueurs.get(i).getCouleur());
//							compteurRouge++;
//							b = false;
//						}else if(a == 0) {
//							compteurBleu = 5;//Pour sortir de la première boucle
//							compteurRouge = 5;
//							break;
//						} else {
//							System.out.println("Veuillez taper l'un des chiffres proposés.");
//							System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
//									+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
//						}
//
//					} catch (InputMismatchException e) {
//						Application.sc.nextLine(); // Pour suppr la touche entrée du flux
//						System.out.println("On a dit un nombre !");
//					}
//				}
//			}
//		}
	}

	@Transactional
	public void setRoleJoueur(int id) {//Set le role d'un joueur devant son PC
		System.out.println("Choisir un rôle (Maitre ou Agent)");
		int compteurMaitreBleu = 0;
		int compteurMaitreRouge = 0;
		Joueur joueur = new Joueur();
		
		try {

			joueur = daoJoueur.findById(id).orElseThrow(Exception::new);
		} catch (Exception e) {
			System.out.println("ERREUR CreationEquipe.setCouleurJoueur : n'arrive pas à trouver le joueur");
		}
		
		while (true) {
			try {
				int a = Application.sc.nextInt();

				if (a == 1) {
					joueur.setRole("Maitre");
					System.out.println(joueur.getPersonne().getPseudo() + " a la couleur "
							+ joueur.getCouleur());
					if (joueur.getCouleur().equals("Bleu")) {
						compteurMaitreBleu++;
						System.out.println("compteurMaitreBleu = " + compteurMaitreBleu);
					} else if (joueur.getCouleur().equals("Rouge")) {
						compteurMaitreRouge++;
						System.out.println("compteurMaitreRouge = " + compteurMaitreRouge);
					} else {
						System.out.println("Le joueur n'a pas de couleur !?");
					}
					break;
				} else if (a == 2) {
					joueur.setRole("Agent");
					System.out.println(joueur.getPersonne().getPseudo() + " a la couleur "
							+ joueur.getCouleur());
					break;
				} else if (a == 0) {
					compteurMaitreBleu = 0;// Pour sortir de la première boucle
					compteurMaitreRouge = 0;
					break;
				} else {
					System.out.println(
							"Personne " + joueur.getPersonne().getPseudo() + "choissé votre rôle");
					System.out.println("Taper 1 pour Maitre, 2 pour Agent, 0 pour arrête");
				}

			} catch (InputMismatchException e) {
				Application.sc.nextLine(); // Pour suppr la touche entrée du flux
				System.out.println("On a dit un nombre !");
			}
		}
		

//		do {
//			compteurMaitreBleu = 0;
//			compteurMaitreRouge = 0;
//
//			for (int i = 0; i < joueurs.size(); i++) {
//				System.out.println("Personne " + joueurs.get(i).getPersonne().getPseudo() + " choisissez votre rôle");
//				System.out.println("Taper 1 pour Maitre, 2 pour Agent, 0 pour arrêter");
//
//				boolean b = true;
//				while (b) {
//					try {
//						int a = Application.sc.nextInt();
//
//						if (a == 1) {
//							joueurs.get(i).setRole("Maitre");
//							System.out.println(joueurs.get(i).getPersonne().getPseudo() + " a la couleur "
//									+ joueurs.get(i).getCouleur());
//							if (joueurs.get(i).getCouleur().equals("Bleu")) {
//								compteurMaitreBleu++;
//								System.out.println("compteurMaitreBleu = " + compteurMaitreBleu);
//							} else if (joueurs.get(i).getCouleur().equals("Rouge")) {
//								compteurMaitreRouge++;
//								System.out.println("compteurMaitreRouge = " + compteurMaitreRouge);
//							} else {
//								System.out.println("Le joueur n'a pas de couleur !?");
//							}
//							b = false;
//						} else if (a == 2) {
//							joueurs.get(i).setRole("Agent");
//							System.out.println(joueurs.get(i).getPersonne().getPseudo() + " a la couleur "
//									+ joueurs.get(i).getCouleur());
//							b = false;
//						} else if (a == 0) {
//							compteurMaitreBleu = 0;// Pour sortir de la première boucle
//							compteurMaitreRouge = 0;
//							b = false;
//						} else {
//							System.out.println(
//									"Personne " + joueurs.get(i).getPersonne().getPseudo() + "choissé votre rôle");
//							System.out.println("Taper 1 pour Maitre, 2 pour Agent, 0 pour arrête");
//						}
//
//					} catch (InputMismatchException e) {
//						Application.sc.nextLine(); // Pour suppr la touche entrée du flux
//						System.out.println("On a dit un nombre !");
//					}
//				}
//			}
//		} while (compteurMaitreBleu > 1 || compteurMaitreRouge > 1);

	}

}
