package pe.edu.upc.entidades;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TypeTrip")
public class TypeTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTypeTrip;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;

	public TypeTrip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeTrip(int idTypeTrip, String name) {
		super();
		this.idTypeTrip = idTypeTrip;
		this.name = name;
	}

	public int getIdTypeTrip() {
		return idTypeTrip;
	}

	public void setIdTypeTrip(int idTypeTrip) {
		this.idTypeTrip = idTypeTrip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTypeTrip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeTrip other = (TypeTrip) obj;
		return idTypeTrip == other.idTypeTrip;
	}
	
	
}
