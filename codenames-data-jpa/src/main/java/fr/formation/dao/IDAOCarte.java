package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Carte;
import fr.formation.model.Grille;

public interface IDAOCarte extends JpaRepository<Carte, Integer> {
	public List<Carte> findAllByGrille(Grille grille);

}
