package fr.formation.dao;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Partie;

public interface IDAOPartie extends IDAO <Partie, Integer>{
	public void rejoindrePartie() throws NoGameFound;
	public void spectatePartie() throws NoGameFound;
}
