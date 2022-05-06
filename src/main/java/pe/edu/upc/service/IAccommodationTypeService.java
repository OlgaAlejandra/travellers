package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.AccommodationType;

public interface IAccommodationTypeService {

	public void insert(AccommodationType at);

	public List<AccommodationType> list();

	public void delete(int idAccommodationType);
}
