package fr.formation.dao;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.dao.exception.WrongPassword;
import fr.formation.dao.exception.WrongPseudo;
import fr.formation.model.Partie;
import fr.formation.model.Personne;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDAOPersonne extends JpaRepository<Personne, Integer>{
	public List<Personne> findByPartieId(int idPartie);
	//public Personne inscription(String pseudo, String password) throws UsernameAlreadyExists; C EST JUSTE UN SAVE EN FAIT
	//public Personne connexion(String pseudo, String password) throws WrongPassword, WrongPseudo; ET LA CA SERA JUSTE DEUX FINDBYLEBELLE A LA SUITE EN FAIT
	//public List<Personne> findPartie(int id); ET LA BAH AHAHAHAHAHAH CA SERA JUSTE UN FIND AVEC UN QUERY POUR RETROUVER LES PARTIES EN FAIT
	//public List<Partie> listeParties (String pseudo) throws NoGameFound; CETTE METHODE VA DANS PARTIE
}