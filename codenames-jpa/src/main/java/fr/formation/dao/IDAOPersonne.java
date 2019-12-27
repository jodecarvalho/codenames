package fr.formation.dao;

import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.model.Personne;
import java.util.List;

public interface IDAOPersonne extends IDAO<Personne, Integer>{
	public Personne inscription(String pseudo, String password) throws UsernameAlreadyExists;
	public Personne connexion();
	public List<Personne> findPartie(int id);
}