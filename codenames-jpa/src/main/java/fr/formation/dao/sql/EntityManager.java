package fr.formation.dao.sql;

import java.sql.ResultSet;
import java.util.ArrayList;

import fr.formation.model.Carte;
import fr.formation.model.Joueur;
import fr.formation.model.Mot;
import fr.formation.model.Partie;
import fr.formation.model.Personne;


public class EntityManager {
	private ArrayList<Personne> personnes = new ArrayList<Personne>();
	private ArrayList<Partie> mesParties = new ArrayList<Partie>();
	private ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();
	private ArrayList<Carte> mesCartes = new ArrayList<Carte>();
	private ArrayList<Mot> mesMots = new ArrayList<>();
	
	public ArrayList<Personne> getPersonnes() {
		return personnes;
	}

	public void setPersonnes(Personne personne) {
		this.personnes.add(personne);
	}
	
	/*public Personnes getPersonne(ResultSet result) throws SQLException {
		String pseudo = result.getString("pseudo");
		String password = result.getString("password");
		// Existe-t-il ?
		for (Personnes p : this.personnes) {
			if (p.getPseudo().equals(pseudo)) {
				System.out.println("Ce pseudo est déjà pris.");
				return null;
			}
		}
		// Je suis arrivé là, DONC : le fournisseur n'existe pas
		Personnes maPersonne = new Personnes();
		// On affecte les infos du fournisseur
		maPersonne.setPseudo(pseudo);
		maPersonne.setPassword(password);
		this.personnes.add(maPersonne);
		return maPersonne;
	}*/
	
	public Personne getPersonne(ResultSet result) {
		int id = 0;
		try {
			id = result.getInt("idpers");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans getPersonne ID");
			
		}
		
		for(Personne p : this.personnes) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		Personne per = new Personne();
		try {
			per.setId(result.getInt("idpers"));
			per.setPseudo(result.getString("pseudo"));
			per.setPassword(result.getString("password"));
			//fou.setId(id);// <= une propôsition de moi
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans getPersonne");
		}
	
		
		this.personnes.add(per);
		return per;
	}
	
	
	public Partie getPartie(ResultSet result) {
		int id = 0;
		try {
			id = result.getInt("");
		}catch(Exception e) {
			System.out.println("Erreur dans getPartie ID");
			
		}
		
		for(Partie p : this.mesParties) {
			if(p.getId() == id) {
				return p;
			}
		}
		
		Partie par = new Partie();
		try {
			par.setId(result.getInt("idpartie"));
			//fou.setId(id);// <= une propôsition de moi
			
		}
		catch(Exception e) {
			System.out.println("Erreur dans getPartie (get ID partie");
		}
	
		
		this.mesParties.add(par);
		return par;
	}
	
	public Joueur getJoueur (ResultSet result) {
		int id = 0;
		try {
			id = result.getInt("idjoueur");
		}catch(Exception e) {
			System.out.println("Erreur dans getJoueur ID");
			
		}
		
		for(Joueur j : this.mesJoueurs) {
			if(j.getId() == id) {
				return j;
			}
		}
		
		Joueur jou = new Joueur();
		try {
			jou.setId(result.getInt("idjoueur"));
			jou.setCouleur(result.getString("couleur"));
			jou.setRole(result.getString("role"));
					
			//fou.setId(id);// <= une propôsition de moi
			
		}
		catch(Exception e) {
			System.out.println("Erreur dans getJoueur");
		}
	
		
		this.mesJoueurs.add(jou);
		return jou;
	}
	
	public Carte getCartes (ResultSet result) {
		int id = 0;
		try {
			id = result.getInt("");
		}catch(Exception e) {
			System.out.println("Erreur dans getCartes ID");
			
		}
		
		for(Carte c : this.mesCartes) {
			if(c.getId() == id) {
				return c;
			}
		}
		
		Carte car = new Carte();
		try {
			car.setId(result.getInt("idplaque"));
			car.setCouleur(result.getString("couleur"));
			car.setDecouvert(result.getBoolean("decouvert"));
			car.setPos_x(result.getInt("x"));
			car.setPos_y(result.getInt("y"));
			//fou.setId(id);// <= une propôsition de moi
			
		}
		catch(Exception e) {
			System.out.println("Erreur dans getCartes");
		}
	
		
		this.mesCartes.add(car);
		return car;
	}
	
	public Mot getMots (ResultSet result) {
		int id = 0;
		try {
			id = result.getInt("");
		}catch(Exception e) {
			System.out.println("Erreur dans getMots ID");
			
		}
		
		for(Mot m : this.mesMots) {
			if(m.getId() == id) {
				return m;
			}
		}
		
		Mot mot = new Mot();
		try {
			mot.setId(result.getInt("idmot"));
			mot.setMot(result.getString("mot"));
			//fou.setId(id);// <= une propôsition de moi
			
		}
		catch(Exception e) {
			System.out.println("Erreur dans getMots");
		}
	
		
		this.mesMots.add(mot);
		return mot;
	}
	
		

}
