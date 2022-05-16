package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.Destination;
import pe.edu.upc.entidades.Tour;
import pe.edu.upc.service.IDestinationService;
import pe.edu.upc.service.ITourService;

@Named
@RequestScoped
public class TourController {

	@Inject
	private ITourService tService;
	
	@Inject
	private IDestinationService dService;
	
	private Tour to;
	List<Tour> listaTours;
	List<Destination> listaDestinations;
	
	@PostConstruct
	public void init() {
		this.to = new Tour();
		this.listaTours = new ArrayList<Tour>();
		this.listaDestinations = new ArrayList<Destination>();
		this.listDestinations();
		this.list();	
	}
	
	public void insert() {
		try {
			tService.insert(to);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador Tour");
		}
	}

	public void list() {
		try {
			listaTours = tService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Tour");
		}
	}
	
	public void listDestinations() {
		try {
			listaDestinations = dService.list();
		} catch (Exception e) {
			System.out.println("Error al listar Destinations en el controlador Accommodation");
		}
	}	
	
	public String updatePre(Tour tour) {
		this.setTo(tour);
		return "updateTour.xhtml";
	}
	
	public void update() {
		try {
			tService.update(this.to);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controller Tour");
		}
	}
	
	public void delete(Tour tr) {
		try {
			tService.delete(tr.getIdTour());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller Tour");
		}
	}
	
	public void findByNameTour() {
		try {
			listaTours = tService.findByNameTour(this.getTo());
		} catch (Exception e) {
			System.out.println("Error al buscar tour en el controlador");
		}
	}
	
	public Tour getTo() {
		return to;
	}

	public void setTo(Tour to) {
		this.to = to;
	}

	public List<Tour> getListaTours() {
		return listaTours;
	}

	public void setListaTours(List<Tour> listaTours) {
		this.listaTours = listaTours;
	}

	public List<Destination> getListaDestinations() {
		return listaDestinations;
	}

	public void setListaDestinations(List<Destination> listaDestinations) {
		this.listaDestinations = listaDestinations;
	}
    
    
}
