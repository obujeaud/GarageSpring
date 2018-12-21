package formation.afpa.garage;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "location")
@Transactional
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_location;
	@OneToOne(fetch = FetchType.LAZY)
	private Box lBox;
	@OneToOne(fetch = FetchType.LAZY)
	private Vehicule lVehicule;
	@Column(name = "tarif")
	private float tarif;
	@Column(name = "debut")
	private Date date;
	@Column(name = "fin")
	private Date fin;

	public Location(Box lBox, Vehicule lVehicule, float tarif, Date date, Date fin) {
		super();
		this.lBox = lBox;
		this.lVehicule = lVehicule;
		this.tarif = tarif;
		this.date = date;
		this.fin = fin;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_location() {
		return id_location;
	}

	public Box getlBox() {
		return lBox;
	}

	public void setlBox(Box lBox) {
		this.lBox = lBox;
	}

	public Vehicule getlVehicule() {
		return lVehicule;
	}

	public void setlVehicule(Vehicule lVehicule) {
		this.lVehicule = lVehicule;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Location [id_location=" + id_location + ", lBox=" + lBox + ", lVehicule=" + lVehicule + ", tarif="
				+ tarif + ", date=" + date + ", fin=" + fin + "]";
	}
}