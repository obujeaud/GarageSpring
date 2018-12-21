package formation.afpa.garage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "garage")
public class Garage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_garage;
	@Column(name = "nom")
	private String nom;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Box> lBox = new HashSet<>();

	public Garage(String nom, Address address) {
		super();
		this.nom = nom;
		this.address = address;
	}

	public Garage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajoutBox(Box b) {
		lBox.add(b);
	}

	public Long getId_garage() {
		return id_garage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		String res = "Garage : id=" + id_garage + ", nom=" + nom + ", address=" + address + ", boxes:";
		for (Box b : lBox) {
			res += "		" + b.toString();
			if (b.getLoc() != null) {
				res += "		" + b.getLoc().getlVehicule().toString();
				res += "		" + b.getLoc().getlVehicule().toString();
			}
		}
		return res;
	}
}