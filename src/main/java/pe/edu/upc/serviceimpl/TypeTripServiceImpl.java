package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITypeTripDao;
import pe.edu.upc.entidades.TypeTrip;
import pe.edu.upc.service.ITypeTripService;

@Named
public class TypeTripServiceImpl implements ITypeTripService{

	@Inject
	private ITypeTripDao tpDao;
	
	@Override
	public void insert(TypeTrip tp) {
		tpDao.insert(tp);
	}

	@Override
	public List<TypeTrip> list() {
		return tpDao.list();
	}

	@Override
	public void delete(int idTypeTrip) {
		tpDao.delete(idTypeTrip);
	}

	
}
