package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;


@Entity 
@Table(name = "mot")
public class Mot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_MOT")
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name="LIBELLE_MOT",length = 100, nullable = false)
	@NotEmpty
	@Size(max = 50)
	@JsonView(Views.Mot.class)//mot est un attribut de Mot
	private String mot;
	
	@OneToOne(mappedBy = "monMot")
	@JsonView(Views.MotFetchingCarte.class)//MotFetchingCarte extends Mot => Carte est un attribut de Mot
	private Carte carte;

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

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
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
