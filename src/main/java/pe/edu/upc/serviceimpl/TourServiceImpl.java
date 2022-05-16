package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITourDao;
import pe.edu.upc.entidades.Tour;
import pe.edu.upc.service.ITourService;

@Named
public class TourServiceImpl implements ITourService{

	@Inject
	private ITourDao tDao;

	@Override
	public void insert(Tour t) {
		tDao.insert(t);
	}

	@Override
	public List<Tour> list() {
		return tDao.list();
	}

	@Override
	public void update(Tour t) {
		tDao.update(t);
	}

	@Override
	public List<Tour> findByNameTour(Tour t) {
		return tDao.findByNameTour(t);
	}

	@Override
	public void delete(int idTour) {
		tDao.delete(idTour);
	}
	
	
}
