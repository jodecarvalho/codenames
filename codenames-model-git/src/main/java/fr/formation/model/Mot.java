package fr.formation.model;

public class Mot {
	private int id;
	private String mot;
	// private DAOConnectionSQL myConnection = new DAOConnectionSQL();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public void setIdRandom() {
		this.id = (int) (Math.random() * 698);
	}

//	public int getId() {
//		return id;
//	}
//	
//	public void setId() {
//		/*int n[] = new int[25];
//		for(int i = 0 ; i<25; i++) {
//			n[i] = (int)(Math.random() * 5);
//			
//		}*/
//		this.id = (int)(Math.random() * 698);
//	}
//	
//	
//	public String getMot() {
//		return mot;
//	}	
//		
//	
//	/*public void setMot(int id) {
//		ResultSet myResult = null;
//		PreparedStatement myStatement = null;
//		//DAOConnectionSQL connection = new DAOConnectionSQL();
//			
//		try {
//			System.out.println("Set Mot");
//			if (myConnection != null) {
//				System.out.println("Set Mot commande SELECT");
//				//myStatement= myConnection.getMyConnection().prepareStatement("SELECT * FROM mots WHERE idmot = ?");
//				myStatement= myConnection.prepareStatement("SELECT * FROM mots WHERE idmot = ?");
//				myStatement.setInt(1, id);
//				myResult = myStatement.executeQuery();
//				
//				while(myResult.next()) {
//					System.out.println("Set Mot getString");
//					 this.mot = myResult.getString("mot");
//					//Produit pro = em.getProduit(myResult);
//					
//				}
//				
//				
//			}
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("Erreur dans l'attribution du mot");
//		}
//	}
}
