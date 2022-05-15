package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.Accommodation;

public interface IAccommodationService {
	
	public void insert(Accommodation a);
	
	public List<Accommodation> list();
	
	public void update(Accommodation a);
	
	public List<Accommodation> findByNameAccommodation(Accommodation a);

	public void delete(int idAccommodation);
}
