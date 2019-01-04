package formation.afpa.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;

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
public class VehiculeT {
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private VehiculeRepo vr;
	private Vehicule v;
	
	@Before
	public void setUp() {
		Vehicule vtest = new Vehicule("Renault", "Kangoo", new Date(2000), "AAA-11-BBB");
		entity.persist(vtest);
		v = vtest;
	}
	
	@Test
	public void createVehicule() {
		Vehicule c = new Vehicule("Peugeot", "205 Turbo 16", new Date(1995), "CCC-22-DDD");
		vr.save(c);
		assertNotNull(vr.findById(c.getId_vehicule()));
	}

	@Test
	public void getVehiculeId() {
		Vehicule i = vr.findById(v.getId_vehicule()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateVehicule() {
		Vehicule i = v;
		i.setMarque("Pugeut");
		vr.save(i);
		assertEquals(i.getMarque(), vr.findById(v.getId_vehicule()).get().getMarque());
	}

	@Test
	public void deleteVehicule() {
		vr.delete(entity.find(Vehicule.class, v.getId_vehicule()));
		assert (entity.find(Vehicule.class, v.getId_vehicule()) == null);
	}

	@Test
	public void deleteVehiculeId() {
		vr.deleteById(v.getId_vehicule());
		assert (entity.find(Vehicule.class, v.getId_vehicule()) == null);
	}

}
