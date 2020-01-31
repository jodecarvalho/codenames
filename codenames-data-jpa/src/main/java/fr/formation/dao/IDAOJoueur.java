package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Joueur;

public interface IDAOJoueur extends JpaRepository<Joueur, Integer>{
	@Query("select j from Joueur j where j.partie.id = :id")
	List<Joueur> findByPartieId(@Param("id") int id);
} 
