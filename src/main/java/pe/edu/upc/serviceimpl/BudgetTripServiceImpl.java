package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IBudgetTripDao;
import pe.edu.upc.entidades.BudgetTrip;
import pe.edu.upc.service.IBudgetTripService;

@Named
public class BudgetTripServiceImpl implements IBudgetTripService{

	@Inject
	private IBudgetTripDao btDao;
	
	@Override
	public void insert(BudgetTrip bt) {
		btDao.insert(bt);
	}

	@Override
	public List<BudgetTrip> list() {
		return btDao.list();
	}

	@Override
	public void update(BudgetTrip bt) {
		btDao.update(bt);
	}

	@Override
	public void delete(int idBudgetTrip) {
		btDao.delete(idBudgetTrip);
	}

}
