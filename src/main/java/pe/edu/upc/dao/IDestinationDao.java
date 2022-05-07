package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.Destination;

public interface IDestinationDao {

	public void insert(Destination d);
	
	public List<Destination> list();
	
	public void update(Destination d);
	
	public void delete(int idDestination);
}
