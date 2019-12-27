package fr.formation.dao.hibernate;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import fr.formation.dao.IDAO;
import fr.formation.dao.IDAOPartie;
import fr.formation.dao.exception.NoGameFound;
import fr.formation.model.Grille;
import fr.formation.model.Joueur;
import fr.formation.model.Partie;

public class DAOPartieHibernate extends DAOConnectionHibernate implements IDAOPartie{

	@Override
	public List<Partie> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Partie p", Partie.class).getResultList();
	}

	@Override
	public Partie findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Partie.class, id);
	}

	@Override
	public Partie save(Partie entity) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		Partie entityMerge = null;
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
	public void delete(Partie entity) {
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
	public void rejoindrePartie() throws NoGameFound {
			List<Partie> myQuery = em.createQuery("select p from Partie p where p.etat = 'creation'", Partie.class)
					.getResultList();
			if (myQuery.size() == 0) {
				throw new NoGameFound();
			}
			else {
				System.out.println("Là théoriquement on choisit la partie que l'on veut intégrer, mais ce n'est pas encore codé");
			}
	}

}
