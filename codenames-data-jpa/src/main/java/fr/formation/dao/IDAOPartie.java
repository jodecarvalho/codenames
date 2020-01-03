package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Grille;
import fr.formation.model.Partie;

public interface IDAOPartie extends JpaRepository <Partie, Integer>{
	public List<Partie> findByEtat(String etat);
	public List<Partie> findByJoueurPersonnePseudo(String pseudo);
	//public List<Partie> rejoindrePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public void spectatePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public Grille afficherGrillePartie(Partie partie); ON VERRA CA PLUS TARD
}
