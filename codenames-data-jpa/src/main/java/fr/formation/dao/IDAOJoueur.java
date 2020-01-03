package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Joueur;

public interface IDAOJoueur extends JpaRepository<Joueur, Integer>{
} 
