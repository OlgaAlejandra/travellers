package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entidades.Usuario;

public interface IUsuarioService {

	public void insert(Usuario u);
	
	public List<Usuario> list();
	
	public void delete(int idUsuario);
}
