package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityTransaction;

import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOCarte;
import fr.formation.model.Carte;
import fr.formation.model.Mot;

public class DAOCarteHibernate extends DAOConnectionHibernate implements IDAOCarte{

	@Override
	public List<Carte> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Carte c", Carte.class).getResultList();
	}

	@Override
	public Carte findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Carte.class, id);
	}

	@Override
	public Carte save(Carte entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Carte entityMerge = null;
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
	public void delete(Carte entity) {
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
		Carte carte = em.find(Carte.class, id);
		try {
			em.getTransaction().begin();
			em.remove(em.merge(carte));
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}	
	}

}