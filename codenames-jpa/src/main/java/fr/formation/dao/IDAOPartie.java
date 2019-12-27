package fr.formation.dao;

import java.util.List;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Partie;

public interface IDAOPartie extends IDAO <Partie, Integer>{
	public void rejoindrePartie() throws NoGameFound;
}
