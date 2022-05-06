package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;

import pe.edu.upc.dao.ITypeTripDao;
import pe.edu.upc.entidades.TypeTrip;

public class TypeTripImplDao implements ITypeTripDao{
	
	@PersistenceContext(unitName = "travellers")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(TypeTrip tp) {
		try {
			em.persist(tp);
		} catch (Exception e) {
			System.out.println("Error al insertar TypeTrip");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeTrip> list() {
		List<TypeTrip> listaTypeTrips = new ArrayList<TypeTrip>();
		try {
			Query jpql = em.createQuery("from TypeTrip tp");
			listaTypeTrips = (List<TypeTrip>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar TypeTrip");
		}
		return listaTypeTrips;
	}

	@Transactional
	@Override
	public void delete(int idTypeTrip) {
		try {
			TypeTrip ty = em.find(TypeTrip.class, idTypeTrip);
			em.remove(ty);
		} catch (Exception e) {
			System.out.println("Error al eliimar en el dao");
		}
	}

}
