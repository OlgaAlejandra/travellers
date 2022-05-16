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
@Table(name = "Tour")
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTour;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Column(name = "description", nullable = false, length = 300)
	private String description;
	
	@Column(name = "location", nullable = false, length = 100)
	private String location;
	
	@Column(name="price", nullable = false)
	private double price;
	
	@Column(name = "availability", nullable = false)
	private Date availability;
	
	@Column(name = "image")
	private Blob image;
	
	@ManyToOne
	@JoinColumn(name = "idDestination", nullable = false)
	private Destination destination;

	public Tour() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Tour(int idTour, String name, String description, String location, double price, Date availability,
			Blob image, Destination destination) {
		super();
		this.idTour = idTour;
		this.name = name;
		this.description = description;
		this.location = location;
		this.price = price;
		this.availability = availability;
		this.image = image;
		this.destination = destination;
	}


	public int getIdTour() {
		return idTour;
	}

	public void setIdTour(int idTour) {
		this.idTour = idTour;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getAvailability() {
		return availability;
	}

	public void setAvailability(Date availability) {
		this.availability = availability;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tour other = (Tour) obj;
		return idTour == other.idTour;
	}


}
