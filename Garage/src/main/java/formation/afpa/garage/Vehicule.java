package formation.afpa.garage;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicule extends Voiture {
	@Column(name = "immat", length = 10)
	private String immat;

	public Vehicule(String modele, String marque, Date date, String immat) {
		super(modele, marque, date);
		this.immat = immat;
	}

	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicule(String modele, String marque, Date date) {
		super(modele, marque, date);
		// TODO Auto-generated constructor stub
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	@Override
	public String toString() {
		return "Vehicule [id_vehicule=" + id_voiture + ", modele=" + modele + ", marque=" + marque + ", date=" + date
				+ " immat=" + immat + "]";
	}
}