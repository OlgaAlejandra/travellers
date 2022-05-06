package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.BudgetTrip;

public interface IBudgetTripService {
	
	public void insert(BudgetTrip bt);

	public List<BudgetTrip> list();

	public void update(BudgetTrip bt);

	public void delete(int idBudgetTrip);
}
