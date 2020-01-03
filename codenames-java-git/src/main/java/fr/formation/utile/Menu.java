package fr.formation.utile;

import java.util.InputMismatchException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.Application;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.IDAOPersonne;
//import fr.formation.dao.IDAOProduit;
import fr.formation.dao.exception.NoGameFound;
import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.dao.exception.WrongPassword;
import fr.formation.dao.exception.WrongPseudo;
import fr.formation.dao.hibernate.DAOPartieHibernate;
import fr.formation.dao.hibernate.DAOPersonneHibernate;
import fr.formation.exception.LireChiffreFormatException;
import fr.formation.model.Personne;

@Service
public class Menu {
	@Autowired
	private IDAOPersonne menuPersonne;
	
	@Autowired
	private IDAOPartie menuPartie;
	
	
	@Transactional
	public Personne lancementJeu() throws LireChiffreFormatException{
		boolean bonChiffre = false;
		Personne personne = new Personne();
		System.out.println("Bienvenue sur CodeNames Online®");
		System.out.println("");
		System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
				+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
		System.out.println("");
		while (bonChiffre == false) {
			try {
				int a = Application.sc.nextInt();
				if (a == 1) {
				personne = this.reconnexionPersonne(personne);
				bonChiffre = true;
				} 
				else {
					if (a == 2) {
						personne = this.creationPersonne(personne);
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
				Application.sc.nextLine(); //Pour suppr la touche entrée du flux
				throw new LireChiffreFormatException();
			}
		}
		bonChiffre = false;
		while(bonChiffre == false) {
			try {
				this.mainMenu(personne);
				bonChiffre = true;
			}
			catch(LireChiffreFormatException e) {
				System.out.println("Veuillez saisir un chiffre");
				System.out.println("");
			}
		}
		return personne;
	}
	
	@Transactional
	private Personne creationPersonne(Personne personne) {
		//IDAOPersonne menu = new DAOPersonneHibernate();
		boolean pseudoLibre = false;
		while(pseudoLibre == false) {
			System.out.println("Veuillez saisir le pseudo que vous voulez prendre.");
			String pseudo = Application.sc.next();
			personne.setPseudo(pseudo);
			System.out.println("Veuillez saisir votre mot de passe.");
			String password = Application.sc.next();
			personne.setPseudo(password);
			try {
				//personne = menu.inscription(pseudo, password);
				personne = menuPersonne.save(personne);
				pseudoLibre = true;
			} catch (Exception e) {
				e.getStackTrace();
				System.out.println("Ce pseudo est déjà pris");
				System.out.println("");
			}
		}
		return personne;
	}
	
	@Transactional
	private Personne reconnexionPersonne(Personne personne) {
		//IDAOPersonne menu = new DAOPersonneHibernate();
		boolean personneExist = false;
		while(personneExist == false) {
			System.out.println("Veuillez saisir votre pseudo.");
			String pseudo = Application.sc.next();
			System.out.println("Veuillez saisir votre mot de passe");
			String password = Application.sc.next();
			try {
				//personne = menu.connexion(pseudo, password);
				personne = menuPersonne.findByLibelle(pseudo);
				
				personneExist = true;
			}
			catch(WrongPseudo e) {
				System.out.println("Ce pseudo n'existe pas, veuillez réessayer.");
				System.out.println("");
			}
			catch(WrongPassword e) {
				System.out.println("Mauvais mot de passe, veuillez réessayer.");
				System.out.println("");
			}
		}
		return personne;
	}
	
	@Transactional
	private void mainMenu(Personne personne) throws LireChiffreFormatException{
		boolean bonChiffre = false;
		//IDAOPartie menu = new DAOPartieHibernate();
		while(bonChiffre==false) {
			System.out.println("Vous êtes dans le menu principal de CodeNames Online®");
			System.out.println("");
			System.out.println("Pour créer une nouvelle partie, tapez 1.");
			System.out.println("Pour chercher une partie en cours de création, tapez 2.");
			System.out.println("Pour regarder une partie en cours, tapez 3.");
			System.out.println("Pour afficher votre historique ou celui d'un autre joueur, tapez 4.");
			System.out.println("Pour vous déconnecter du jeu, tapez 0.");
			try {
					int a = Application.sc.nextInt();
					if(a == 1) {
						MenuCreationPartie creationPartie = new MenuCreationPartie();
						int id = creationPartie.setPartie(personne);
						creationPartie.attenteJoueurs(id);
						bonChiffre = true;
					}
					else {
						if(a == 2) {
							try {
								//menu.rejoindrePartie();
								menuPartie.rejoindrePartie();
								MenuRejoindrePartie rejoindreLaPartie = new MenuRejoindrePartie();
								rejoindreLaPartie.rejoindrePartie(personne);
								bonChiffre = true;
							}
							catch(NoGameFound e) {
								System.out.println("Aucune partie en cours de création n'a été trouvée.");
								System.out.println("");
							}
						}
						else {
							if(a==3) {
								try {
									//menu.spectatePartie();
									menuPartie.spectatePartie();
									bonChiffre = true;
								}
								catch(NoGameFound e) {
									System.out.println("Aucune partie en cours n'a été trouvée.");
									System.out.println("");
								}
							}
							else {
								System.out.println("Veullez saisir un des chiffres proposés dans le menu.");
								System.out.println("");
							}
						}
					}
			}
			catch(InputMismatchException e) {
				Application.sc.nextLine(); //Pour suppr la touche entrée du flux
				throw new LireChiffreFormatException();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private Personne personne = new Personne();
//	
//	
//	public void gameConnection() {
//		boolean bonChiffre = false;
//		System.out.println("Bienvenue sur CodeNames Online®");
//		System.out.println("");
//		System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
//				+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
//		System.out.println("");
//		while (bonChiffre == false) {
//			try {
//				int a = Application.sc.nextInt();
//				if (a == 1) {
//					//menu est une personne
//					//
//					personne = menu.reconnexionPersonne();
//					bonChiffre = true;
//				} 
//				else {
//					if (a == 2) {
//						personne = menu.creationPersonne();
//						bonChiffre = true;
//					} 
//					else {
//						System.out.println("Veuillez taper l'un des chiffres proposés.");
//						System.out.println("Afin de commencer à jouer, veuillez soit vous connecter en tapant"
//								+ "le chiffre 1, soit vous inscrire en tapant le chiffre 2.");
//					}
//				}
//			}
//			catch(Exception e) {
//				e.getStackTrace();
//				System.out.println("ERREUR dans le Menu");
//			}
//		}
//	}
//	
//	public Personne creationPersonne(){
//		System.out.println("Veuillez saisir le pseudo que vous voulez prendre.");
//		String pseudo = Application.sc.next();
//		PreparedStatement monStatement = null;
//		try {
//			if(connection != null) {
//				Statement myStatement = connection.createStatement();
//				ResultSet myResult = myStatement.executeQuery(
//						"SELECT * FROM personnes");
//
//				while (myResult.next()) {
//					if(myResult.getString("pseudo").equals(pseudo)) {
//						while(myResult.getString("pseudo").equals(pseudo)) {
//						System.out.println("Ce pseudo est déjà pris, veuillez saisir un pseudo libre.");
//						pseudo = Application.sc.next();
//						}
//					}
//				}
//					System.out.println("Veuillez saisir votre mot de passe.");
//					String password = Application.sc.next();
//					monStatement = connection.prepareStatement("INSERT INTO personnes"
//							+ " (pseudo, password) VALUES (?, ?)");
//					monStatement.setString(1,pseudo);
//					monStatement.setString(2,password);
//					monStatement.execute();
//					Personne personne = new Personne();
//					personne.setPseudo(pseudo);
//					personne.setPassword(password);
//					return personne;
//			}
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			System.out.println("Une erreur s'est produite.");
//		}
//		return null;
//	}
	
//	public Personne reconnexionPersonne() {
//		boolean successConnection = false;
//		System.out.println("Veuillez saisir votre pseudo:");
//		String pseudo = Application.sc.next();
//		System.out.println("Veuillez saisir votre mot de passe");
//		String password = Application.sc.next();
//		try {
//			if(connection != null) {
//				Statement myStatement = connection.createStatement();
//				
//				while (successConnection==false) {
//					ResultSet myResult = myStatement.executeQuery("SELECT * FROM personnes");
//					while (myResult.next()) {
//						if(myResult.getString("pseudo").equals(pseudo) 
//								&& myResult.getString("password").contentEquals(password)) {
//							System.out.println("Connexion réussie.");
//							Personne personne = new Personne();
//							personne.setPseudo(pseudo);
//							personne.setPassword(password);
//							successConnection = true;
//							return personne;
//						}
//					}
//					System.out.println("Ce pseudo n'existe pas ou votre mot de passe est incorrect."
//							+ "Veuillez ressaisir vos informations");
//					System.out.println("Veuillez saisir votre pseudo:");
//					pseudo = Application.sc.next();
//					System.out.println("Veuillez saisir votre mot de passe");
//					password = Application.sc.next();
//					}
//			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("woopsy");
//		}
//		return null;		
//	}
	
	
	
}
