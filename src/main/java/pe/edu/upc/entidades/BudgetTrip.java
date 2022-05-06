package pe.edu.upc.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "BudgetTrip")
public class BudgetTrip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBudgetTrip;
	
	@Column(name = "budgetAmount", nullable = false)
	private int budgetAmount;
	
	@Column(name="numDays", nullable = false)
	private int numDays;
	
	@Column(name="numPeople", nullable = false)
	private int numPeople;
	
	@ManyToOne
	@JoinColumn(name = "idTypeTrip", nullable = false)
	private TypeTrip typeTrip;

	public BudgetTrip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BudgetTrip(int idBudgetTrip, int budgetAmount, int numDays, int numPeople, TypeTrip typeTrip) {
		super();
		this.idBudgetTrip = idBudgetTrip;
		this.budgetAmount = budgetAmount;
		this.numDays = numDays;
		this.numPeople = numPeople;
		this.typeTrip = typeTrip;
	}

	public int getIdBudgetTrip() {
		return idBudgetTrip;
	}

	public void setIdBudgetTrip(int idBudgetTrip) {
		this.idBudgetTrip = idBudgetTrip;
	}

	public int getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(int budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public int getNumPeople() {
		return numPeople;
	}

	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}

	public TypeTrip getTypeTrip() {
		return typeTrip;
	}

	public void setTypeTrip(TypeTrip typeTrip) {
		this.typeTrip = typeTrip;
	}
	
	
}
