package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.formation.dao.IDAO;
import fr.formation.dao.hibernate.DAOConnectionHibernate;
import fr.formation.model.Mot;

public class DAOMotHibernate extends DAOConnectionHibernate implements IDAO <Mot, Integer>{

	@Override
	public List<Mot> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select m from Mot m", Mot.class).getResultList();
	}

	@Override
	public Mot findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Mot.class, id);
	}

	@Override
	public Mot save(Mot entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Mot entityMerge = null;
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
	public void delete(Mot entity) {
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
		Mot mot = em.find(Mot.class, id);
		try {
			em.getTransaction().begin();
			em.remove(em.merge(mot));
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
	}

}
