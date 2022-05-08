package pe.edu.upc.serviceimpl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IUsuarioDao;
import pe.edu.upc.entidades.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService{

	@Inject
	private IUsuarioDao uDao;
	
	@Override
	public void insert(Usuario u) {
		uDao.insert(u);
	}

	@Override
	public List<Usuario> list() {
		return uDao.list();
	}

	@Override
	public void delete(int idUsuario) {
		uDao.delete(idUsuario);
	}

	@Override
	public void update(Usuario u) {

		uDao.update(u);
	}

	
}
