package fr.formation.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Grille;
import fr.formation.model.Partie;

public interface IDAOGrille extends JpaRepository<Grille, Integer> {
	public Grille findByPartie(Partie partie);
}
