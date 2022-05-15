package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAccommodationDao;
import pe.edu.upc.entidades.Accommodation;
import pe.edu.upc.service.IAccommodationService;

@Named
public class AccommodationServiceImpl implements IAccommodationService{

	@Inject
	private IAccommodationDao aDao;
	
	@Override
	public void insert(Accommodation a) {	
		aDao.insert(a);
	}

	@Override
	public List<Accommodation> list() {
		return aDao.list();
	}

	@Override
	public void update(Accommodation a) {
		aDao.update(a);
	}

	@Override
	public List<Accommodation> findByNameAccommodation(Accommodation a) {
		return aDao.findByNameAccommodation(a);
	}

	@Override
	public void delete(int idAccommodation) {
		aDao.delete(idAccommodation);
	}

	
}
