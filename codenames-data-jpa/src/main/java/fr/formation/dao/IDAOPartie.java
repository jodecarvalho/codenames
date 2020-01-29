package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Grille;
import fr.formation.model.Partie;

public interface IDAOPartie extends JpaRepository <Partie, Integer>{
	public List<Partie> findByEtat(String etat);
	public List<Partie> findByMesJoueursPersonnePseudo(String pseudo);
	public List<Partie> findByMesJoueursPersonneId(int id);
	public int countByMesJoueursCouleur(String couleur);
	
	@Query("select p from Partie p inner join fetch p.mesJoueurs j where j.personne.pseudo = :pseudo")
	public List<Partie> findByJoueursPersonnePseudo(@Param("pseudo") String pseudo);
	
//	@(select p from Partie pa left join fetch pa.joueurs j  )
//	public List<Partie> findPartiesByIdPersonne(int id);
	//public List<Partie> rejoindrePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public void spectatePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public Grille afficherGrillePartie(Partie partie); ON VERRA CA PLUS TARD
}
