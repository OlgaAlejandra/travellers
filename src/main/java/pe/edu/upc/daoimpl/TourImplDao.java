package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITourDao;
import pe.edu.upc.entidades.Tour;

public class TourImplDao implements ITourDao{

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insert(Tour t) {
		try {
			em.persist(t);
		} catch (Exception e) {
			System.out.println("Error al insertar Tour");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> list() {
		List<Tour> listaTours = new ArrayList<Tour>();
		try {
			Query jpql = em.createQuery("from Tour t");
			listaTours = (List<Tour>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en Tour");
		}
		return listaTours;
	}

	@Transactional
	@Override
	public void update(Tour t) {
		try {
			em.merge(t);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao Tour");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> findByNameTour(Tour t) {
		List<Tour> lista = new ArrayList<Tour>();
		try {
			Query q = em.createQuery("from Tour t where t.name like ?1");
			q.setParameter(1, "%" + t.getName() + "%");
			lista = (List<Tour>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Errror al buscar Tour");
		}
		return lista;
	}

	@Transactional
	@Override
	public void delete(int idTour) {
		try {
			Tour to = em.find(Tour.class, idTour);
			em.remove(to);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el Tour");
		}
	}
	
	

}
