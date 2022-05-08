package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.TypeTrip;
import pe.edu.upc.service.ITypeTripService;

@Named
@RequestScoped
public class TypeTripController {

	@Inject
	private ITypeTripService tpService;
	
	private TypeTrip tp;
	List<TypeTrip> listaTypeTrips;
	
	@PostConstruct
	public void init() {
		this.listaTypeTrips = new ArrayList<TypeTrip>();
		this.tp = new TypeTrip();
		this.list();
	}

	public String newTypeTrip() {
		this.setTp(new TypeTrip());
		return "typeTrip.xhtml";
	}
	
	public void insert() {
		try {
			tpService.insert(tp);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller TypeTrip");
		}
	}
	
	public void list() {
		try {
			listaTypeTrips = tpService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller TypeTrip");
		}
	}
	
	
	public void delete(TypeTrip trp) {
		try {
			tpService.delete(trp.getIdTypeTrip());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller TypeTrip");
		}
	}
	
	public String updatePre(TypeTrip typeTrip) {
		this.setTp(typeTrip);
		return "updateTypeTrip.xhtml";
	}
	
	public void update() {
		try {
			tpService.update(this.tp);
		} catch (Exception e) {
			System.out.println("Eror al modificar en el controlador de TypeTrip");
		}
	}
	
	public TypeTrip getTp() {
		return tp;
	}

	public void setTp(TypeTrip tp) {
		this.tp = tp;
	}

	public List<TypeTrip> getListaTypeTrips() {
		return listaTypeTrips;
	}

	public void setListaTypeTrips(List<TypeTrip> listaTypeTrips) {
		this.listaTypeTrips = listaTypeTrips;
	}
	
	
}
