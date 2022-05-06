package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.AccommodationType;

public interface IAccommodationTypeDao {
	
	public void insert(AccommodationType at);
	
	public List<AccommodationType> list();
	
	public void delete(int idAccommodationType);
}
