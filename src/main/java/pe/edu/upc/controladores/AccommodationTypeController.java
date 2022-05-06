package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.AccommodationType;
import pe.edu.upc.service.IAccommodationTypeService;

@Named
@RequestScoped
public class AccommodationTypeController {

	@Inject
	private IAccommodationTypeService atService;
	
	private AccommodationType at;
	List<AccommodationType> listaAccommodationTypes;
	
	@PostConstruct
	public void init() {
		this.listaAccommodationTypes = new ArrayList<AccommodationType>();
		this.at = new AccommodationType();
		this.list();
	}
	
	public String newAccommodationType() {
		this.setAt(new AccommodationType());
		return "accommodationType.xhtml";
	}

	public void insert() {
		try {
			atService.insert(at);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controller AccommodationType");
		}
	}
	
	public void list() {
		try {
			listaAccommodationTypes = atService.list();
		} catch (Exception e) {
			System.out.println("Error al listar en controller AccommodationType");
		}
	}
	
	public void delete(AccommodationType atype) {
		try {
			atService.delete(atype.getIdAccommodationType());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller AccommodationType");
		}
	}
	public AccommodationType getAt() {
		return at;
	}

	public void setAt(AccommodationType at) {
		this.at = at;
	}

	public List<AccommodationType> getListaAccommodationTypes() {
		return listaAccommodationTypes;
	}

	public void setListaAccommodationTypes(List<AccommodationType> listaAccommodationTypes) {
		this.listaAccommodationTypes = listaAccommodationTypes;
	}
	
	
}
