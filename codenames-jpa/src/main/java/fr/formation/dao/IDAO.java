package fr.formation.dao;

import java.util.List;

public interface IDAO<T, Id> {
	public List<T> findAll();//List plus g�n�rique que ArrayList
	public T findById(Id id);
	public T save(T entity);
	public void delete(T entity);
	public void deleteById(Id id);
	
}
