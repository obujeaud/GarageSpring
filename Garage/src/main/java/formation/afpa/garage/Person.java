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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id_person;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "nom")
	private String nom;
	@OneToMany(cascade = CascadeType.REMOVE)
	private Set<Voiture> voitList = new HashSet<>();
	@OneToMany(cascade = CascadeType.REMOVE)
	private Set<Garage> gList = new HashSet<>();

	public void ajoutVoiture(Voiture v) {
		voitList.add(v);
	}

	public void ajoutGarage(Garage g) {
		gList.add(g);
	}

	public Person(String prenom, String nom) {
		super();
		this.prenom = prenom;
		this.nom = nom;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_person() {
		return id_person;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String preno) {
		this.prenom = preno;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Person [id_person=" + id_person + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
}