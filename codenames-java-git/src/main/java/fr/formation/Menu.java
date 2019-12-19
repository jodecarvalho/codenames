package fr.formation;

import java.util.InputMismatchException;

import DAO.DAOPersonneSQL;
import fr.formation.codenames.Personne;
import fr.formation.exception.LireChiffreFormatException;

public class Menu {

	public Personne gameConnection() throws LireChiffreFormatException{
		boolean bonChiffre = false;
		Personne personne = new Personne();
		DAOPersonneSQL menu = new DAOPersonneSQL();
		System.out.println("Bienvenue sur CodeNames Online®");
		System.out.println("");
		System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
				+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
		System.out.println("");
		while (bonChiffre == false) {
			try {
				int a = Application.sc.nextInt();
				if (a == 1) {
					personne = menu.reconnexionPersonne();
					bonChiffre = true;
				} 
				else {
					if (a == 2) {
						personne = menu.creationPersonne();
						bonChiffre = true;
					} 
					else {
						System.out.println("Veuillez taper l'un des chiffres proposés.");
						System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
								+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
					}
				}
			}
			catch(InputMismatchException e) {
				throw new LireChiffreFormatException();
			}
		}
		return personne;
	}
	private void mainMenu() throws LireChiffreFormatException{
		boolean bonChiffre = false;
		System.out.println("Vous êtes dans le menu principal de CodeNames Online®");
		System.out.println("Pour créer une nouvelle partie, tapez 1.");
		System.out.println("Pour chercher une partie en cours de création, tapez 2.");
		System.out.println("Pour regarder une partie en cours, tapez 3.");
		System.out.println("Pour afficher votre historique ou celui d'un autre joueur, tapez 4.");
		System.out.println("Pour vous déconnecter du jeu, tapez 0.");
	}
}
