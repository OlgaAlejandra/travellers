package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IAccommodationDao;
import pe.edu.upc.entidades.Accommodation;

public class AccommodationImplDao implements IAccommodationDao{

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Accommodation a) {
		try {
			em.persist(a);
		} catch (Exception e) {
			System.out.println("Error al insertar Accommodation");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accommodation> list() {
		List<Accommodation> listaAccommodations = new ArrayList<Accommodation>();
		try {
			Query jpql = em.createQuery("from Accommodation a");
			listaAccommodations = (List<Accommodation>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en Accommodation");
		}
		return listaAccommodations;
	}
	
	@Transactional
	@Override
	public void update(Accommodation a) {
		try {
			em.merge(a);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao Accommodation");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accommodation> findByNameAccommodation(Accommodation a) {
		List<Accommodation> lista = new ArrayList<Accommodation>();
		try {
			Query q = em.createQuery("from Accommodation a where a.name like ?1");
			q.setParameter(1, "%" + a.getName() + "%" );
			lista = (List<Accommodation>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar Accommodation");
		}
		
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idAccommodation) {
		try {
			Accommodation ac = em.find(Accommodation.class, idAccommodation);
			em.remove(ac);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el Accommodation");
		}
	}

}
