package fr.formation.dao.hibernate;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOPersonne;
import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;
import fr.formation.model.Personne;

public class DAOPersonneHibernate extends DAOConnectionHibernate implements IDAOPersonne {

	@Override
	public List<Personne> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Personne p", Personne.class).getResultList();
	}

	@Override
	public Personne findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Personne.class, id);
	}

	@Override
	public Personne save(Personne entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Personne entityMerge = null;
		tx.begin();
		try {
			if (entity.getId() == 0) {
				em.persist(entity);
			} else {
				entityMerge = em.merge(entity);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return entityMerge;
	}

	@Override
	public void delete(Personne entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.remove(em.merge(entity));
			em.getTransaction().commit();

		} catch (Exception e) {
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

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Personne inscription(String pseudo, String password) throws UsernameAlreadyExists {
		Personne personne = new Personne();
		TypedQuery<Personne> myQuery = em.createQuery("select p from Personne p where p.pseudo = :lepseudo",Personne.class);
		myQuery.setParameter("lepseudo", pseudo);
		
		try {
			myQuery.getSingleResult();
			throw new UsernameAlreadyExists();
		}
		
		catch (NoResultException e) {
			//RIEN A FAIRE ICI
		}
		
		//ON CONTINUE L'INSCRIPTION
		personne.setPseudo(pseudo);
		personne.setPassword(password);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(personne);
			tx.commit();
		}
		catch(Exception e) {}
		return personne;
	}

	@Override
	public Personne connexion() {
		// TODO Auto-generated method stub
		return null;
	}

}
