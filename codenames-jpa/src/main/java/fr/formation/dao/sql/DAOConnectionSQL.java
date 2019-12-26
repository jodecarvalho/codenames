package fr.formation.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAOConnectionSQL {
	
	protected static Connection myConnection = null;//Static pour éviter d'avoir plusieurs instance de connection à la création d'un DAOConnectionSQL
	//Une seul instance Connection pour toute les connections
	//protected static int i = 0;//Si on veut vérifier le rôle de static on peut l'enlever et le remettre pour voir la différence sur i (i est là pour l'exemple)
	//static va permettre de garder la même adresse mémoire de i. Si on retir le static l'adresse mémoire va être changé à chaque appel.
	protected static EntityManager em =null;

	
		
	public DAOConnectionSQL() {
		System.out.println("CREATION CONNEXION SQL");
		this.setMyConnection();
		//System.out.println(i);
		//i++;
		//System.out.println(i);
	}

	public Connection getMyConnection() {
		
		return myConnection;
	}

	public void setMyConnection() {
		try {
			System.out.println("SETUP SQL");
			if(em == null) {
				em = new EntityManager();
			}
			if(myConnection == null) {//Vérifie de connection de manière général existe
				System.out.println("CONNEXION"); //Si on enlève le static on aurra plusieurs CONNEXION
				myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenames?serverTimezone=UTC", "root", "psD44!&");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur connection SQL");
		}
		
	}


}
