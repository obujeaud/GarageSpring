package formation.afpa.garage;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "box")
@Transactional
public class Box {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_box;
	@Column(name = "numEmplacement")
	private int numEmplacement;
	@Column(name = "surface")
	private double surface;
	@OneToOne(cascade = CascadeType.REMOVE, mappedBy = "lBox")
	private Location loc;

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public Box(int d, double e) {
		super();
		this.numEmplacement = d;
		this.surface = e;
	}

	public Box() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_box() {
		return id_box;
	}

	public int getNumEmplacement() {
		return numEmplacement;
	}

	public void setNumEmplacement(int numEmplacement) {
		this.numEmplacement = numEmplacement;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	@Override
	public String toString() {
		return "Box [id_box=" + id_box + ", numEmplacement=" + numEmplacement + ", surface=" + surface + "]";
	}
}