package fr.formation.dao;

import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.dao.exception.WrongPassword;
import fr.formation.dao.exception.WrongPseudo;
import fr.formation.model.Personne;
import java.util.List;

public interface IDAOPersonne extends IDAO<Personne, Integer>{
	public Personne inscription(String pseudo, String password) throws UsernameAlreadyExists;
	public Personne connexion();
}