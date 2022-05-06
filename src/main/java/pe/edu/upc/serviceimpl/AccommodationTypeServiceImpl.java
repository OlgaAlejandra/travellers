package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IAccommodationTypeDao;
import pe.edu.upc.entidades.AccommodationType;
import pe.edu.upc.service.IAccommodationTypeService;

public class AccommodationTypeServiceImpl implements IAccommodationTypeService{

	@Inject
	private IAccommodationTypeDao atDao;
	
	@Override
	public void insert(AccommodationType at) {
		atDao.insert(at);
	}

	@Override
	public List<AccommodationType> list() {
		return atDao.list();
	}

	@Override
	public void delete(int idAccommodationType) {
		atDao.delete(idAccommodationType);
	}

	
}
