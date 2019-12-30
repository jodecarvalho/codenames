package fr.formation.dao;
import fr.formation.model.Grille;

public interface IDAOGrille extends IDAO<Grille, Integer> {
	public void afficherGrille(Grille grille);
}
