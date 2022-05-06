package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IBudgetTripDao;
import pe.edu.upc.entidades.BudgetTrip;

public class BudgetTripImplDao implements IBudgetTripDao{

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(BudgetTrip bt) {
		try {
			em.persist(bt);
		} catch (Exception e) {
			System.out.println("Error al insertar budgetTrip");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BudgetTrip> list() {
		List<BudgetTrip> listaBudgetTrips = new ArrayList<BudgetTrip>();
		try {
			Query jpql = em.createQuery("from BudgetTrip bt");
			listaBudgetTrips = (List<BudgetTrip>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en BudgetTrip");
		}
		return listaBudgetTrips;
	}
	
	@Transactional
	@Override
	public void update(BudgetTrip bt) {

		try {
			em.merge(bt);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de budgetTrip");
		}
	}
	
	@Transactional
	@Override
	public void delete(int idBudgetTrip) {
		try {
			BudgetTrip bu = em.find(BudgetTrip.class, idBudgetTrip);
			em.remove(bu);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el budgetTrip");
		}
	}
	
	

}
