package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Carte;
import fr.formation.model.Mot;

public interface IDAOMot extends JpaRepository<Mot, Integer>{

}
