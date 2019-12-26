package fr.formation.dao.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.formation.dao.IDAO;
import fr.formation.model.Mot;

public class DAOMotSQL extends DAOConnectionSQL implements IDAO <Mot, Integer>{

	@Override
	public List<Mot> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mot findById(Integer id) {
		// TODO Auto-generated method stub
		ResultSet myResult = null;
		PreparedStatement myStatement = null;
		//DAOConnectionSQL connection = new DAOConnectionSQL();
		Mot monMot = new Mot();
		try {
			System.out.println("Set Mot");
			if (myConnection != null) {
				System.out.println("Set Mot commande SELECT");
				//myStatement= myConnection.getMyConnection().prepareStatement("SELECT * FROM mots WHERE idmot = ?");
				myStatement= myConnection.prepareStatement("SELECT * FROM mots WHERE idmot = ?");
				myStatement.setInt(1, id);
				myResult = myStatement.executeQuery();
				
				while(myResult.next()) {
					System.out.println("Set Mot getString");
					 monMot.setMot(myResult.getString("mot"));
					//Produit pro = em.getProduit(myResult);
					
				}
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur dans l'attribution du mot");
		}
		
		return monMot;
	}

	@Override
	public Mot save(Mot entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Mot entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
