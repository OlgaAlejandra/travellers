package pe.edu.upc.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Destination")
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDestination;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name = "description", nullable = false, length = 200)
	private String description;
	
	@Column(name="country", nullable = false, length = 50)
	private String country;
	
	@Column(name = "numAccommodation", nullable = false)
	private int numAccommodation;
	
	@Column(name="numTour", nullable = false)
	private int numTour;
	
	@Column(name = "numRestaurant", nullable = false)
	private int numRestaurant;
	
	@Column(name = "numAttraction", nullable = false)
	private int numAttraction;
	
	@ManyToOne
	@JoinColumn(name = "idTypeTrip", nullable = false)
	private TypeTrip typeTrip;

	public Destination() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Destination(int idDestination, String name, String description, String country, int numAccommodation,
			int numTour, int numRestaurant, int numAttraction, TypeTrip typeTrip) {
		super();
		this.idDestination = idDestination;
		this.name = name;
		this.description = description;
		this.country = country;
		this.numAccommodation = numAccommodation;
		this.numTour = numTour;
		this.numRestaurant = numRestaurant;
		this.numAttraction = numAttraction;
		this.typeTrip = typeTrip;
	}


	public int getIdDestination() {
		return idDestination;
	}


	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getNumAccommodation() {
		return numAccommodation;
	}


	public void setNumAccommodation(int numAccommodation) {
		this.numAccommodation = numAccommodation;
	}


	public int getNumTour() {
		return numTour;
	}


	public void setNumTour(int numTour) {
		this.numTour = numTour;
	}


	public int getNumRestaurant() {
		return numRestaurant;
	}


	public void setNumRestaurant(int numRestaurant) {
		this.numRestaurant = numRestaurant;
	}


	public int getNumAttraction() {
		return numAttraction;
	}


	public void setNumAttraction(int numAttraction) {
		this.numAttraction = numAttraction;
	}


	public TypeTrip getTypeTrip() {
		return typeTrip;
	}


	public void setTypeTrip(TypeTrip typeTrip) {
		this.typeTrip = typeTrip;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idDestination);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destination other = (Destination) obj;
		return idDestination == other.idDestination;
	}
	
	
	
}
