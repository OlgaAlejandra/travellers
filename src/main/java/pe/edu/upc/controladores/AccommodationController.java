package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.Accommodation;
import pe.edu.upc.entidades.AccommodationType;
import pe.edu.upc.entidades.Destination;
import pe.edu.upc.service.IAccommodationService;
import pe.edu.upc.service.IAccommodationTypeService;
import pe.edu.upc.service.IDestinationService;

@Named
@RequestScoped
public class AccommodationController {

	@Inject
	private IAccommodationService aService;
	
	@Inject
	private IDestinationService dService;
	
	@Inject
	private IAccommodationTypeService atService;
	
	private Accommodation acc;
	List<Accommodation> listaAccommodations;
	List<Destination> listaDestinations;
	List<AccommodationType> listaAccommodationTypes;
	
	@PostConstruct
	public void init() {
		this.acc = new Accommodation();
		this.listaAccommodations = new ArrayList<Accommodation>();
		this.listaDestinations = new ArrayList<Destination>();
		this.listaAccommodationTypes = new ArrayList<AccommodationType>();
		this.listAccommodationTypes();
		this.listDestinations();
		this.list();
	}
	
	public void insert() {
		try {
			aService.insert(acc);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador Accommodation");
		}
	}
	
	public void list() {
		try {
			listaAccommodations = aService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Accommodation");
		}
	}
	public void listAccommodationTypes() {
		try {
			listaAccommodationTypes = atService.list();
		} catch (Exception e) {
			System.out.println("Error al listar AccommodationTypes en el controlador Accommodation");
		}
	}
	
	public void listDestinations() {
		try {
			listaDestinations = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Destinations en el controlador Accommodation");
		}
	}
	
	public String updatePre(Accommodation accommodation) {
		this.setAcc(accommodation);
		return "updateAccommodation.xhtml";
	}
	
	public void update() {
		try {
			aService.update(this.acc);
		} catch (Exception e) {
			System.out.println("Error al modiifcar en el controller Accommodation");
		}
	}
	
	public void delete(Accommodation an) {
		try {
			aService.delete(an.getIdAccommodation());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Accommodation");
		}
	}

	public void findByNameAccommodation() {
		try {
			listaAccommodations = aService.findByNameAccommodation(this.getAcc());
		} catch (Exception e) {
			System.out.println("Error al buscar accommodation en el controlador");
		}
	}
	
	public Accommodation getAcc() {
		return acc;
	}

	public void setAcc(Accommodation acc) {
		this.acc = acc;
	}

	public List<Accommodation> getListaAccommodations() {
		return listaAccommodations;
	}

	public void setListaAccommodations(List<Accommodation> listaAccommodations) {
		this.listaAccommodations = listaAccommodations;
	}

	public List<Destination> getListaDestinations() {
		return listaDestinations;
	}

	public void setListaDestinations(List<Destination> listaDestinations) {
		this.listaDestinations = listaDestinations;
	}

	public List<AccommodationType> getListaAccommodationTypes() {
		return listaAccommodationTypes;
	}

	public void setListaAccommodationTypes(List<AccommodationType> listaAccommodationTypes) {
		this.listaAccommodationTypes = listaAccommodationTypes;
	}
	
	
}
