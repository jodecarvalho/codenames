package fr.formation;

import java.util.Scanner;

import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Personne;

public class Application {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Personne personne = new Personne();
		Menu menu = new Menu();
		try {
			personne = menu.gameConnection();
		} catch (LireChiffreFormatException e) {
			System.out.println("Veuillez relancer l'application et saisir un chiffre cette fois-ci.");
		}
	}

}
