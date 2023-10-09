package com.fatec.exercicio.persistence;

import java.sql.SQLException;
import java.util.List;

public interface DAO<E> {

	public void insert() throws SQLException, ClassNotFoundException;
	
	public E find(E e) throws SQLException, ClassNotFoundException;
	
	public void update(E e) throws SQLException, ClassNotFoundException;
	
	public List<E> list() throws SQLException, ClassNotFoundException;
	
	public E findFromFunction(E e) throws SQLException, ClassNotFoundException;
	
	public double findSomaSalario(E e) throws SQLException, ClassNotFoundException;
}
