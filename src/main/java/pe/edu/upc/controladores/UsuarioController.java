package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
@RequestScoped
public class UsuarioController {

	@Inject
	private IUsuarioService uService;
	
	private Usuario u;
	List<Usuario> listaUsuarios;
	
	@PostConstruct
	public void init() {
		this.listaUsuarios = new ArrayList<Usuario>();
		this.u = new Usuario();
		this.list();
	}
	
	public String newUsuario() {
		this.setU(new Usuario());
		return "usuario.xhtml";
	}
	
	public void insert() {
		try {
			uService.insert(u);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller usuario");
		}
	}
	
	public void list() {
		try {
			listaUsuarios = uService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller usuario");
		}
	}
	
	public void delete(Usuario usu) {
		try {
			uService.delete(usu.getIdUsuario());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller usuario");
		}
	}
	
	public String updatePre(Usuario usuario) {
		this.setU(usuario);
		return"updateUsuario.xhtml";
	}
	
	public void update() {
		try {
			uService.update(this.u);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controlador de ususario");
		}
	}
	
	public Usuario getU() {
		return u;
	}
	public void setU(Usuario u) {
		this.u = u;
	}
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	
}
