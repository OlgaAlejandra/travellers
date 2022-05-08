package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.AccommodationType;

public interface IAccommodationTypeService {

	public void insert(AccommodationType at);

	public List<AccommodationType> list();

	public void update(AccommodationType at);
	
	public void delete(int idAccommodationType);
}
