package fr.formation.dao;

import java.util.List;

import fr.formation.model.Joueur;

public interface IDAOJoueur extends IDAO<Joueur, Integer>{
	public List<Joueur> findJoueursPartie(int id);
} 
