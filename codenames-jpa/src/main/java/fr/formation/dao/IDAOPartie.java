package fr.formation.dao;

import java.util.List;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Grille;
import fr.formation.model.Partie;

public interface IDAOPartie extends IDAO <Partie, Integer>{
	public List<Partie> rejoindrePartie() throws NoGameFound;
	public void spectatePartie() throws NoGameFound;
	public Grille afficherGrillePartie(Partie partie);
}
