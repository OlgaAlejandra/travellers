package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.TypeTrip;

public interface ITypeTripDao {

	public void insert(TypeTrip tp);
	
	public List<TypeTrip> list();
	
	public void delete(int idTypeTrip);
}
