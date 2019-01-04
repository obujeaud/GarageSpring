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
public class LocationT {
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private LocationRepo lr;
	private Location l;
	List<Box> lbox = new ArrayList<>();
	List<Vehicule> lvehicule = new ArrayList<>();
	
	@Before
	public void setUp() {
		Box b = new Box(1, 1.0);
		Box b2 = new Box(10, 100.0);
		lbox.add(b);
		lbox.add(b2);
		Vehicule v2 = new Vehicule("Renault", "Clio", new Date(1993), "CCC-12-DDD");
		Vehicule v = new Vehicule("Renault", "Kangoo", new Date(2019), "AAA-12-BBB");
		lvehicule.add(v);
		lvehicule.add(v2);
		Location ll = new Location(b, v, 15, new Date(2018), new Date(2019));
		entity.persist(ll);
		l = ll;
	}
	
	@Test
	public void createLocation() {
		Location c = new Location(lbox.get(1), lvehicule.get(1), 150, new Date(1980), new Date(3015));
		lr.save(c);
		assertNotNull(lr.findById(c.getId_location()));
	}

	@Test
	public void getLocationId() {
		Location i = lr.findById(l.getId_location()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateLocation() {
		Location i = l;
		i.setFin(new Date(2020));
		lr.save(i);
		assertEquals(i.getDate(), lr.findById(l.getId_location()).get().getDate());
	}

	@Test
	public void deleteLocation() {
		lr.delete(entity.find(Location.class, l.getId_location()));
		assert (entity.find(Location.class, l.getId_location()) == null);
	}

	@Test
	public void deleteLocationId() {
		lr.deleteById(l.getId_location());
		assert (entity.find(Location.class, l.getId_location()) == null);
	}
}