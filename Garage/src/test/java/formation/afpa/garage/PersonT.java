package formation.afpa.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = GarageApplicationTests.class)
public class PersonT {
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private PersonRepo pr;
	private Person p;
	private Garage gg;
	private List<Box> lbox = new ArrayList<>();
	private List<Vehicule> lvehicule = new ArrayList<>();

	@Before
	public void setUp() {
		Person pp = new Person("Olivier", "Bujeaud");
		Address a = new Address("1 rue du slip", "83510", "Lorgues");
		Garage gtest = new Garage("GarageTest", a);
		Vehicule v2 = new Vehicule("Renault", "Clio", new Date(1993), "CCC-12-DDD");
		Vehicule v = new Vehicule("Renault", "Kangoo", new Date(2019), "AAA-12-BBB");
		lvehicule.add(v);
		lvehicule.add(v2);
		Box b1 = new Box(1, 1.0);
		Box b2 = new Box(2, 2.0);
		gtest.ajoutBox(b1);
		gtest.ajoutBox(b2);
		pp.ajoutGarage(gtest);
		pp.ajoutVoiture(v);
		pp.ajoutVoiture(v2);
		lbox.add(b1);
		lbox.add(b2);
		entity.persist(a);
		entity.persist(gtest);
		entity.persist(b1);
		entity.persist(b2);
		entity.persist(pp);
		entity.persist(v);
		entity.persist(v2);
		p = pp;
		gg = gtest;
	}

	@Test
	public void createPerson() {
		Person c = new Person("Jean", "Pierre");
		pr.save(c);
		assertNotNull(pr.findById(c.getId_person()));
	}

	@Test
	public void getPersonId() {
		Person i = pr.findById(p.getId_person()).get();
		assertNotNull(i);
	}

	@Test
	public void updatePerson() {
		Person i = p;
		i.setNom("siufdhgufdhsgh");
		pr.save(i);
		assertEquals(i.getNom(), pr.findById(p.getId_person()).get().getNom());
	}

	@Test
	public void deletePerson() {
		pr.delete(entity.find(Person.class, p.getId_person()));
		assert (entity.find(Person.class, p.getId_person()) == null);
		assert (entity.find(Garage.class, gg.getId_garage()) == null);
		for (Box b : lbox) {
			assert (entity.find(Box.class, b.getId_box()) == null);
		}
		for (Vehicule v : lvehicule) {
			assert (entity.find(Vehicule.class, v.getId_vehicule()) == null);
		}
	}

	@Test
	public void deletePersonId() {
		pr.deleteById(p.getId_person());
		assert (entity.find(Person.class, p.getId_person()) == null);
		assert (entity.find(Garage.class, gg.getId_garage()) == null);
		for (Box b : lbox) {
			assert (entity.find(Box.class, b.getId_box()) == null);
		}
		for (Vehicule v : lvehicule) {
			assert (entity.find(Vehicule.class, v.getId_vehicule()) == null);
		}
	}
}