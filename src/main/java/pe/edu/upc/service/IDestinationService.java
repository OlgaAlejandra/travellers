package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.Destination;

public interface IDestinationService {

	public void insert(Destination d);
	
	public List<Destination> list();
	
	public void update(Destination d);
	
	public List<Destination> findByNameDestination(Destination d);
	
	public void delete(int idDestination);
}
