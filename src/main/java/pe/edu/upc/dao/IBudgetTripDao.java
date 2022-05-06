package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.BudgetTrip;

public interface IBudgetTripDao {

	public void insert(BudgetTrip bt);
	
	public List<BudgetTrip> list();
	
	public void update(BudgetTrip bt);
	
	public void delete(int idBudgetTrip);
	
}
