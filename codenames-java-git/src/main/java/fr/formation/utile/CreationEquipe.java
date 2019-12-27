package fr.formation.utile;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import fr.formation.Application;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;

public class CreationEquipe {
	
	private List<Joueur> joueurs = new ArrayList<Joueur>();
	
	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public void setupEquipe(List<Personne> personnes) {
		for(Personne p : personnes) {
			this.setCreationJoueur(p);
		}
		this.setCouleurJoueur();
		this.setRoleJoueur();
	}

	public void setCreationJoueur(Personne personne) {
		Joueur joueur = new Joueur();
		joueur.setPersonne(personne);
		joueurs.add(joueur);

	}

	public void setCouleurJoueur() {

		System.out.println("Choisir les équipes");
		int compteurBleu = 0;
		int compteurRouge = 0;

		while (compteurBleu < 2 || compteurRouge < 2) {
			if(compteurBleu < 2 || compteurRouge < 2) {
				compteurBleu = 0;
				compteurRouge = 0;
			}			
			
			for (Joueur j : joueurs) {
				
				System.out.println("Personne " + j.getPersonne().getPseudo() + "choissé votre couleur");
				System.out.println("Taper 1 pour bleu, 2 pour rouge");

				boolean b = true;

				while (b) {
					try {
						int a = Application.sc.nextInt();

						if (a == 1) {
							j.setCouleur("Bleu");
							compteurBleu++;
							b = false;
						} else if (a == 2) {
							j.setCouleur("Rouge");
							compteurRouge++;
							b = false;
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
			}
		}
	}

	public void setRoleJoueur() {
		System.out.println("Choisir un rôle (Maitre ou Agent");
		int compteurMaitreBleu = 0;
		int compteurMaitreRouge = 0;
		
		do{
			compteurMaitreBleu = 0;
			compteurMaitreRouge = 0;
			
			for (Joueur j : joueurs) {
				System.out.println("Personne " + j.getPersonne().getPseudo() + "choissé votre rôle");
				System.out.println("Taper 1 pour Maitre, 2 pour Agent");
				
				boolean b = true;
				while (b) {
					try {
						int a = Application.sc.nextInt();

						if (a == 1) {
							j.setRole("Maitre");
							if(j.getCouleur().equals("Bleu")) {
								compteurMaitreBleu++;
							}
							if(j.getCouleur().equals("Rouge")) {
								compteurMaitreRouge++;
							}
							else {
								System.out.println("Le joueur n'a pas de couleur !?");
							}
							
							b = false;
						} else if (a == 2) {
							j.setCouleur("Agent");
							b = false;
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
				
			}
		}while (compteurMaitreBleu > 1 || compteurMaitreRouge > 1);
		
	}

}
