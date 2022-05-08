package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.Destination;
import pe.edu.upc.entidades.TypeTrip;
import pe.edu.upc.service.IDestinationService;
import pe.edu.upc.service.ITypeTripService;

@Named
@RequestScoped
public class DestinationController {

	@Inject
	private IDestinationService dService;

	@Inject
	private ITypeTripService tpService;

	private Destination des;
	List<Destination> listaDestinations;
	List<TypeTrip> listaTypeTrips;

	@PostConstruct
	public void init() {
		this.des = new Destination();
		this.listaDestinations = new ArrayList<Destination>();
		this.listaTypeTrips = new ArrayList<TypeTrip>();
		this.listTypeTrips();
		this.list();
	}

	public void insert() {
		try {
			dService.insert(des);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de Destination");
		}
	}

	public void list() {
		try {
			listaDestinations = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Destination");
		}
	}

	public void listTypeTrips() {
		try {
			listaTypeTrips = tpService.list();
		} catch (Exception e) {
			System.out.println("Error al istar TypeTrips en el controlador BudgetTrip");
		}
	}
	
	public String updatePre(Destination destination) {
		this.setDes(destination);
		return "updateDestination.xhtml";
	}

	public void update() {
		try {
			dService.update(this.des);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller destination");
		}
	}
	
	public void delete(Destination dt) {
		try {
			dService.delete(dt.getIdDestination());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Destination");
		}
	}
	
	public void findByNameDestination() {
		try {
			listaDestinations = dService.findByNameDestination(this.getDes());
		} catch (Exception e) {
			System.out.println("Error al buscar destino en el controlador");
		}
	}
	
	
	public Destination getDes() {
		return des;
	}

	public void setDes(Destination des) {
		this.des = des;
	}

	public List<Destination> getListaDestinations() {
		return listaDestinations;
	}

	public void setListaDestinations(List<Destination> listaDestinations) {
		this.listaDestinations = listaDestinations;
	}

	public List<TypeTrip> getListaTypeTrips() {
		return listaTypeTrips;
	}

	public void setListaTypeTrips(List<TypeTrip> listaTypeTrips) {
		this.listaTypeTrips = listaTypeTrips;
	}

}
