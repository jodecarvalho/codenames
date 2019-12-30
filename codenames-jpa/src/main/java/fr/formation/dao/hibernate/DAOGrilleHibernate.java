package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOGrille;
import fr.formation.model.Carte;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.dao.hibernate.DAOConnectionHibernate;

public class DAOGrilleHibernate extends DAOConnectionHibernate implements IDAOGrille{

	@Override
	public List<Grille> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select g from Grille g", Grille.class).getResultList();
	}

	@Override
	public Grille findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Grille.class, id);
	}

	@Override
	public Grille save(Grille entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Grille entityMerge = null;
		tx.begin();
		try {
			if(entity.getId() == 0) {
				em.persist(entity);
			}
			else {
				entityMerge = em.merge(entity);			
			}
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}		
		return entityMerge;
	}

	@Override
	public void delete(Grille entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		Joueur joueur = em.find(Joueur.class, id);
		try {
			em.getTransaction().begin();
			em.remove(em.merge(joueur));
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void afficherGrille(Grille grille) {
		List<Carte> myQuery = em
				.createQuery("select g from Grille g where g.id = :leid", Grille.class)
				.setParameter("leid", grille.getId())
				.getSingleResult()
				.getMesCartes();
		myQuery.forEach(c -> {
			System.out.println();
		});
		
	}

}
