package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityTransaction;
import fr.formation.dao.IDAOJoueur;
import fr.formation.dao.hibernate.DAOConnectionHibernate;
import fr.formation.model.Joueur;

public class DAOJoueurHibernate extends DAOConnectionHibernate implements IDAOJoueur{

	@Override
	public List<Joueur> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select j from Joueur j", Joueur.class).getResultList();
	}

	@Override
	public Joueur findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Joueur.class, id);
	}

	@Override
	public Joueur save(Joueur entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Joueur entityMerge = null;
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
	public void delete(Joueur entity) {
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
	public List<Joueur> findJoueursPartie(int id) {
		// TODO Auto-generated method stub

		return null;
	}

}
