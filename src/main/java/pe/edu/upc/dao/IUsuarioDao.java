package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entidades.Usuario;

public interface IUsuarioDao {

	public void insert(Usuario u);
	
	public List<Usuario> list();
	
	public void update(Usuario u);
	
	public void delete(int idUsuario);
}
