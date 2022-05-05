package pe.edu.upc.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entidades.Usuario;

public class UsuarioImplDao implements IUsuarioDao{

	@PersistenceContext(unitName = "travellers")
	private EntityManager em;

	@Transactional
	@Override
	public void insert(Usuario u) {
		try {
			em.persist(u);
		} catch (Exception e) {
			System.out.println("Error al insertar usuario");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			Query jpql = em.createQuery("from Usuario u");
			listaUsuarios = (List<Usuario>) jpql.getResultList();
		} catch (Exception e) {
			System.out.println("Error al listar usuarios");
		}
		return listaUsuarios;
	}

	@Transactional
	@Override
	public void delete(int idUsuario) {

		try {
			Usuario us = em.find(Usuario.class, idUsuario);
			em.remove(us);
		} catch (Exception e) {
			System.out.println("Error al eliminar en el dao");
		}
	}
	
	
}
