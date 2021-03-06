package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import javax.persistence.TypedQuery;


import fr.formation.dao.IDAOPersonne;
import fr.formation.dao.exception.NoGameFound;
import fr.formation.dao.exception.UsernameAlreadyExists;
import fr.formation.dao.exception.WrongPassword;
import fr.formation.dao.exception.WrongPseudo;
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
		tx.begin();
		try {
			if (entity.getId() == 0) {
				em.persist(entity);
			} else {
				entity = em.merge(entity);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return entity;
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
		Personne joueur = em.find(Personne.class, id);
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
		System.out.println("Connexion r�ussie, bienvenue");
		System.out.println("");
		return personne;
	}

	@Override
	public Personne connexion(String pseudo, String password) throws WrongPassword, WrongPseudo {
		Personne personne = new Personne();
		TypedQuery<Personne> myQuery = em.createQuery("select p from Personne p where p.pseudo = :lepseudo", Personne.class);
		myQuery.setParameter("lepseudo", pseudo);
		try {
			if(myQuery.getSingleResult().getPassword().equals(password)) {
				System.out.println("Connexion r�ussie");
				System.out.println("");
				personne.setPseudo(pseudo);
				personne.setPassword(password);
			}
			else {
				throw new WrongPassword();
			}
		}
		catch(NoResultException e) {
			throw new WrongPseudo();
		}
		return personne;
	}
	
	@Override
	public List<Personne> findPartie(int id) {
		// TODO Auto-generated method stub
		return em
				.createQuery("select p from Personne p inner join p.mesJoueurs j where j.partie.id = :idPartie", Personne.class)
				.setParameter("idPartie", id)
				.getResultList();
	}

	@Override
	public List<Partie> listeParties(String pseudo) throws NoGameFound {
		List<Partie>myQuery = em
				.createQuery("select distinct p from Partie p inner join p.mesJoueurs j where j.personne.pseudo = :lepseudo", Partie.class)
				.setParameter("lepseudo", pseudo)
				.getResultList();
		if (myQuery.size()==0) {
			throw new NoGameFound();
		}
		else {
			return myQuery;
		}
	}

}
