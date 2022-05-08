package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;

import pe.edu.upc.dao.IAccommodationTypeDao;
import pe.edu.upc.entidades.AccommodationType;

public class AccommodationTypeImplDao implements IAccommodationTypeDao {

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(AccommodationType at) {
		try {
			em.persist(at);
		} catch (Exception e) {
			System.out.println("Error al insertar en AccommodationType");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccommodationType> list() {
		List<AccommodationType> listaAccommodationTypes = new ArrayList<AccommodationType>();
		try {
			Query jpql = em.createQuery("from AccommodationType at");
			listaAccommodationTypes = (List<AccommodationType>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar AccommodationType");
		}
		
		return listaAccommodationTypes;
	}

	@Transactional
	@Override
	public void delete(int idAccommodationType) {
		try {
			AccommodationType aty = em.find(AccommodationType.class, idAccommodationType);
			em.remove(aty);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el dao");
		}
	}
	
	@Transactional
	@Override
	public void update(AccommodationType at) {
		try {
			em.merge(at);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao AccommodationType");
		}
	}

}
