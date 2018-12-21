package formation.afpa.garage;

import java.sql.Date;
import javax.persistence.CascadeType;
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
@Table(name = "vehicule")
@Transactional
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id_voiture;
	@Column(name = "modele", length = 150)
	protected String modele;
	@Column(name = "marque", length = 150)
	protected String marque;
	@Column(name = "date")
	protected Date date;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "lVehicule", cascade = CascadeType.REMOVE)
	private Location lc;

	public Location getLc() {
		return lc;
	}

	public void setLc(Location lc) {
		this.lc = lc;
	}

	public Voiture(String modele, String marque, Date date) {
		super();
		this.modele = modele;
		this.marque = marque;
		this.date = date;
	}

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_vehicule() {
		return id_voiture;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Vehicule [id_vehicule=" + id_voiture + ", modele=" + modele + ", marque=" + marque + ", date=" + date
				+ "]";
	}
}