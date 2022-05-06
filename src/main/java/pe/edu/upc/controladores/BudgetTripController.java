package pe.edu.upc.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entidades.BudgetTrip;
import pe.edu.upc.entidades.TypeTrip;
import pe.edu.upc.service.IBudgetTripService;
import pe.edu.upc.service.ITypeTripService;

@Named
@RequestScoped
public class BudgetTripController {

	@Inject
	private IBudgetTripService btService;

	@Inject
	private ITypeTripService tpService;

	private BudgetTrip btp;
	List<BudgetTrip> listaBudgetTrips;
	List<TypeTrip> listaTypeTrips;

	@PostConstruct
	public void init() {
		this.btp = new BudgetTrip();
		this.listaBudgetTrips = new ArrayList<BudgetTrip>();
		this.listaTypeTrips = new ArrayList<TypeTrip>();
		this.listTypeTrips();
		this.list();
	}

	public void insert() {
		try {
			btService.insert(btp);
		} catch (Exception e) {
			System.out.println("Error al insertar en el controlador de BudgetTrip");
		}
	}

	public void list() {
		try {
			listaBudgetTrips = btService.list();
		} catch (Exception e) {
			System.out.println("Error al listar BusgetTrips");
		}
	}
	
	public void listTypeTrips() {
		try {
			listaTypeTrips = tpService.list();
		} catch (Exception e) {
			System.out.println("Error al istar TypeTrips en el controlador BudgetTrip");
		}
	}
	
	public String updatePre(BudgetTrip budgetTrip) {
		this.setBtp(budgetTrip);
		return "updateBudgetTrip.xhtml";
	}
	
	public void update() {
		try {
			btService.update(this.btp);
		} catch (Exception e) {
			System.out.println("Error al modificar en el controlador de BudgetTrip");
		}
	}
	
	public void delete(BudgetTrip bud) {
		try {
			btService.delete(bud.getIdBudgetTrip());
			this.list();
		} catch (Exception e) {
			System.out.println("Error al eliminar en el controller BudgetTrip");
		}
	}
	public BudgetTrip getBtp() {
		return btp;
	}

	public void setBtp(BudgetTrip btp) {
		this.btp = btp;
	}

	public List<BudgetTrip> getListaBudgetTrips() {
		return listaBudgetTrips;
	}

	public void setListaBudgetTrips(List<BudgetTrip> listaBudgetTrips) {
		this.listaBudgetTrips = listaBudgetTrips;
	}

	public List<TypeTrip> getListaTypeTrips() {
		return listaTypeTrips;
	}

	public void setListaTypeTrips(List<TypeTrip> listaTypeTrips) {
		this.listaTypeTrips = listaTypeTrips;
	}

}
