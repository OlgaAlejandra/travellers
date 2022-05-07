package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDestinationDao;
import pe.edu.upc.entidades.Destination;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DestinationImplDao implements IDestinationDao{

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Destination d) {
		try {
			em.persist(d);
		} catch (Exception e) {
			System.out.println("Error al insertar destination");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> list() {
		List<Destination> listaDestinations = new ArrayList<Destination>();
		try {
			Query jpql = em.createQuery("from Destination d");
			listaDestinations = (List<Destination>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar en Destination");
		}
		return listaDestinations;
	}
	
	@Transactional
	@Override
	public void update(Destination d) {
		try {
			em.merge(d);
		} catch (Exception e) {
			System.out.println("Error al modificar en el dao de Destination");
		}
	}

	@Transactional
	@Override
	public void delete(int idDestination) {
		try {
			Destination de = em.find(Destination.class, idDestination);
			em.remove(de);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el Destination");
		}
	}
	
	
	
}
