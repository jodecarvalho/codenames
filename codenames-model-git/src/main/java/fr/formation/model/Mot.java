package fr.formation.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Mot extends DAOConnectionSQL {
	private int id;
	private String mot;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		/*int n[] = new int[25];
		for(int i = 0 ; i<25; i++) {
			n[i] = (int)(Math.random() * 5);
			
		}*/
		this.id = (int)(Math.random() * 50);
	}
	
	
	public String getMot() {
		
			
		return mot;
	}	
		
	
	public void setMot(int id) {
		ResultSet myResult = null;
		PreparedStatement myStatement = null;
				
		try {
			if (myConnection != null) {
				myStatement= myConnection.prepareStatement("SELECT * FROM mots WHERE idmot = ?");
				myStatement.setInt(1, id);
				myResult = myStatement.executeQuery();
				
				while(myResult.next()) {
					 this.mot = myResult.getString("MOT");
					//Produit pro = em.getProduit(myResult);
					
				}
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println("Erreur dans l'attribution du mot");
		}
	}
	
	
}
