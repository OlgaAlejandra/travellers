package pe.edu.upc.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AccommodationType")
public class AccommodationType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAccommodationType;
	
	@Column(name = "description", nullable = false, length = 200)
	private String description;
	
	@Column(name="numBeds", nullable = false)
	private int numBeds;
	
	@Column(name="price", nullable = false)
	private double price;
	
	@Column(name = "numSleeps", nullable = false)
	private int numSleeps;

	public AccommodationType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccommodationType(int idAccommodationType, String description, int numBeds, double price, int numSleeps) {
		super();
		this.idAccommodationType = idAccommodationType;
		this.description = description;
		this.numBeds = numBeds;
		this.price = price;
		this.numSleeps = numSleeps;
	}

	public int getIdAccommodationType() {
		return idAccommodationType;
	}

	public void setIdAccommodationType(int idAccommodationType) {
		this.idAccommodationType = idAccommodationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumBeds() {
		return numBeds;
	}

	public void setNumBeds(int numBeds) {
		this.numBeds = numBeds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumSleeps() {
		return numSleeps;
	}

	public void setNumSleeps(int numSleeps) {
		this.numSleeps = numSleeps;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAccommodationType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccommodationType other = (AccommodationType) obj;
		return idAccommodationType == other.idAccommodationType;
	}


	
}
