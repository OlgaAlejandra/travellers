package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.TypeTrip;

public interface ITypeTripService {

	public void insert(TypeTrip tp);
	
	public List<TypeTrip> list();
	
	public void delete(int idTypeTrip);
	
}
