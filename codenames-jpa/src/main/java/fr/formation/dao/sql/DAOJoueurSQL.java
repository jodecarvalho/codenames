package fr.formation.dao.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.dao.IDAO;
import fr.formation.model.Joueur;
import fr.formation.model.Personne;

public class DAOJoueurSQL extends DAOConnectionSQL implements IDAO<Joueur, Integer> {

	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Joueur> mesJoueurs = new ArrayList<Joueur>();

		try {
			if (myConnection != null) {
				Statement myStatement = myConnection.createStatement();
				ResultSet myResult = myStatement.executeQuery(
						"SELECT * FROM personnes AS perso LEFT JOIN joueurs AS jou ON perso.idpers = jou.idjoueur");

				while (myResult.next()) {
					System.out.println(myResult.getString("idpers"));
					try {

						Personne per = em.getPersonne(myResult);
						Joueur jou = em.getJoueur(myResult);
						jou.setPseudo(per.getPseudo());
						jou.setPassword(per.getPassword());


						mesJoueurs.add(jou);
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
			mesJoueurs.clear();
			System.out.println("Erreur lecture tableau");
		}
		
		return mesJoueurs;
	}

	@Override
	public Joueur findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Joueur save(Joueur entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Joueur entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

}
