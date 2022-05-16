package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.Tour;

public interface ITourService {
	
	public void insert(Tour t);
	
	public List<Tour> list();
	
	public void update(Tour t);
	
	public List<Tour> findByNameTour(Tour t);
	
	public void delete(int idTour);
}
