package formation.afpa.garage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_address;
	@Column(name = "adresse", length = 300)
	private String adresse;
	@Column(name = "codePostal", length = 5)
	private String codePostal;
	@Column(name = "ville", length = 100)
	private String ville;

	public Long getId_address() {
		return id_address;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Address(String adresse, String codePostal, String ville) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [id_address=" + id_address + ", adresse=" + adresse + ", codePostal=" + codePostal + ", ville="
				+ ville + "]";
	}
}