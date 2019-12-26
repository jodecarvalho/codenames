package fr.formation.dao.hibernate;

import java.util.List;

import fr.formation.dao.IDAO;
import fr.formation.dao.sql.DAOConnectionSQL;
import fr.formation.model.Grille;

public class DAOGrilleHibernate extends DAOConnectionSQL implements IDAO <Grille, Integer>{

	@Override
	public List<Grille> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grille findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grille save(Grille entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Grille entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
