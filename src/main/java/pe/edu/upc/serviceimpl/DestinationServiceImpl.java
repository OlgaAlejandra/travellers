package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IDestinationDao;
import pe.edu.upc.entidades.Destination;
import pe.edu.upc.service.IDestinationService;

@Named
public class DestinationServiceImpl implements IDestinationService{

	@Inject
	private IDestinationDao dDao;
	
	@Override
	public void insert(Destination d) {
		dDao.insert(d);
	}

	@Override
	public List<Destination> list() {
		return dDao.list();
	}

	@Override
	public void update(Destination d) {
		dDao.update(d);
	}

	@Override
	public void delete(int idDestination) {
		dDao.delete(idDestination);
	}

	@Override
	public List<Destination> findByNameDestination(Destination d) {
		return dDao.findByNameDestination(d);
	}

	
}
