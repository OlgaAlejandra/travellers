package pe.edu.upc.entidades;

import java.sql.Blob;
import java.util.Date;
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
@Table(name = "Accommodation")
public class Accommodation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAccommodation;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "description", nullable = false, length = 300)
	private String description;
	
	@Column(name = "location", nullable = false, length = 100)
	private String location;

	@Column(name = "facilities", nullable = false, length = 200)
	private String facilities;
	
	@Column(name = "availabilityIn", nullable = false)
	private Date availabilityIn;
	
	@Column(name = "availabilityOut", nullable = false)
	private Date availabilityOut;
	
	@Column(name = "numRoomAvailable", nullable = false)
	private int numRoomAvailable;
	
	@ManyToOne
	@JoinColumn(name = "idAccommodationType", nullable = false)
	private AccommodationType accommodationType;
	
	@ManyToOne
	@JoinColumn(name = "idDestination", nullable = false)
	private Destination destination;

	public Accommodation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Accommodation(int idAccommodation, String name, String description, String location, String facilities,
			Date availabilityIn, Date availabilityOut, int numRoomAvailable, AccommodationType accommodationType,
			Destination destination) {
		super();
		this.idAccommodation = idAccommodation;
		this.name = name;
		this.description = description;
		this.location = location;
		this.facilities = facilities;
		this.availabilityIn = availabilityIn;
		this.availabilityOut = availabilityOut;
		this.numRoomAvailable = numRoomAvailable;
		this.accommodationType = accommodationType;
		this.destination = destination;
	}



	public int getIdAccommodation() {
		return idAccommodation;
	}

	public void setIdAccommodation(int idAccommodation) {
		this.idAccommodation = idAccommodation;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public Date getAvailabilityIn() {
		return availabilityIn;
	}

	public void setAvailabilityIn(Date availabilityIn) {
		this.availabilityIn = availabilityIn;
	}

	public Date getAvailabilityOut() {
		return availabilityOut;
	}

	public void setAvailabilityOut(Date availabilityOut) {
		this.availabilityOut = availabilityOut;
	}

	public int getNumRoomAvailable() {
		return numRoomAvailable;
	}

	public void setNumRoomAvailable(int numRoomAvailable) {
		this.numRoomAvailable = numRoomAvailable;
	}

	public AccommodationType getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(AccommodationType accommodationType) {
		this.accommodationType = accommodationType;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idAccommodation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accommodation other = (Accommodation) obj;
		return idAccommodation == other.idAccommodation;
	}
	
	
}
