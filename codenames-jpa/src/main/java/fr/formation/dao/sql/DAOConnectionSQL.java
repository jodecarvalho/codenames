package fr.formation.dao.sql;

import java.sql.Connection;
import java.sql.DriverManager;


public class DAOConnectionSQL {
	
	protected static Connection myConnection = null;//Static pour �viter d'avoir plusieurs instance de connection � la cr�ation d'un DAOConnectionSQL
	//Une seul instance Connection pour toute les connections
	//protected static int i = 0;//Si on veut v�rifier le r�le de static on peut l'enlever et le remettre pour voir la diff�rence sur i (i est l� pour l'exemple)
	//static va permettre de garder la m�me adresse m�moire de i. Si on retir le static l'adresse m�moire va �tre chang� � chaque appel.
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
			if(myConnection == null) {//V�rifie de connection de mani�re g�n�ral existe
				System.out.println("CONNEXION"); //Si on enl�ve le static on aurra plusieurs CONNEXION
				myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/codenames?serverTimezone=UTC", "root", "psD44!&");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Erreur connection SQL");
		}
		
	}


}
