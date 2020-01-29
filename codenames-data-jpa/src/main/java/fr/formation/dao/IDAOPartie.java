package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Grille;
import fr.formation.model.Partie;

public interface IDAOPartie extends JpaRepository <Partie, Integer>{
	public List<Partie> findByEtat(String etat);
	public List<Partie> findByMesJoueursPersonnePseudo(String pseudo);
	public List<Partie> findByMesJoueursPersonneId(int id);
	public int countByMesJoueursCouleur(String couleur);
	
//	@Query("select p from Partie p left join fetch p.mesJoueurs j inner join fetch j.personne where p.pseudo = :pseudo")
//	public List<Partie> findByJoueursPersonnePseudo(String pseudo);
	
//	@(select p from Partie pa left join fetch pa.joueurs j  )
//	public List<Partie> findPartiesByIdPersonne(int id);
	//public List<Partie> rejoindrePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public void spectatePartie() throws NoGameFound; C EST UN FINDBYETAT
	//public Grille afficherGrillePartie(Partie partie); ON VERRA CA PLUS TARD
}
