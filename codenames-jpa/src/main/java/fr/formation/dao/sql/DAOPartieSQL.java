package fr.formation.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.dao.IDAO;
import fr.formation.model.Carte;
import fr.formation.model.Joueur;
import fr.formation.model.Mot;
import fr.formation.model.Partie;
import fr.formation.model.Personne;


public class DAOPartieSQL extends DAOConnectionSQL implements IDAO <Partie, Integer>{

	@Override
	public List<Partie> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Partie> mesParties = new ArrayList<Partie>();
		
		try {
			if (myConnection != null) {
				Statement myStatement = myConnection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM joueurs AS jou INNER JOIN grilles AS gri ON jou.idjoueur = gri.idgrille INNER");

				while (myResult.next()) {
					// System.out.println(myResult.getString("PRO_ID"));
					try {

						
						Partie par = em.getPartie(myResult);
						Mot mot = em.getMots(myResult);
						Carte car =em.getCartes(myResult);
						car.setMonMot(mot);
						par.getMaGrille().getMesCartes().add(car);
						
						Personne per = em.getPersonne(myResult);
						Joueur jou = em.getJoueur(myResult);
						jou.setPseudo(per.getPseudo());
						jou.setPassword(per.getPassword());
						
						par.getMesJoueurs().add(jou);
						
						mesParties.add(par);
						
					}

					catch (Exception e) {
						e.printStackTrace();
						System.out.println("Erreur de récupération dans la liste");
					}

					// System.out.println(myResult.getString("PRO_LIBELLE"));
					// ...
				}
			}
		} catch (SQLException e) {
			// ...
			mesParties.clear();
			System.out.println("Erreur lecture tableau");
		}

		return mesParties;
	}

	@Override
	public Partie findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Partie save(Partie entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Partie entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
