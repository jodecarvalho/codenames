package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Carte;
import fr.formation.model.Grille;

public interface IDAOCarte extends JpaRepository<Carte, Integer> {
	public List<Carte> findAllByGrille(Grille grille);
	
	@Query("select c from Carte c inner join fetch Grille g where g.partie.id = :id")//Puisqu'il y a un seul mot dans la classe pas besoin inner join fetch Mot m
	public List<Carte> findAllByIdPartie(int id);

}
