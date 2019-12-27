package fr.formation.dao;

import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.model.Personne;

public interface IDAOPersonne extends IDAO<Personne, Integer>{

	public Personne inscription(String pseudo, String password) throws UsernameAlreadyExists;
	public Personne connexion();
}
