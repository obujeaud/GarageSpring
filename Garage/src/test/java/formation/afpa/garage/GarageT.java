package formation.afpa.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class GarageT {
	
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private GarageRepo gr;
	private Garage g;
	private Address aa;
	private List<Box> lbox = new ArrayList<>();
	
	@Before
	public void setUp() {
		Address a = new Address("1 rue du slip", "83510", "Lorgues");
		Garage gtest = new Garage("GarageTest", a);
		Box b1 = new Box(1, 1.0);
		Box b2 = new Box(2, 2.0);
		gtest.ajoutBox(b1);
		gtest.ajoutBox(b2);
		lbox.add(b1);
		lbox.add(b2);
		entity.persist(a);
		entity.persist(gtest);
		entity.persist(b1);
		entity.persist(b2);
		g = gtest;
		aa = a;
	}
	
	@Test
	public void createGarage() {
		Garage c = new Garage("Gtest", new Address("2 rue du slip", "83510", "Lorgues"));
		gr.save(c);
		assertNotNull(gr.findById(c.getId_garage()));
	}

	@Test
	public void getGarageId() {
		Garage i = gr.findById(g.getId_garage()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateGarage() {
		Garage i = g;
		i.setNom("Bloup");
		gr.save(i);
		assertEquals(i.getNom(), gr.findById(g.getId_garage()).get().getNom());
	}

	@Test
	public void deleteGarage() {
		gr.delete(entity.find(Garage.class, g.getId_garage()));
		assert (entity.find(Garage.class, g.getId_garage()) == null);
		assert (entity.find(Address.class, aa.getId_address()) == null);
		for(Box b : lbox) {
			assert(entity.find(Box.class, b.getId_box()) == null);
		}
	}

	@Test
	public void deleteGarageId() {
		gr.deleteById(g.getId_garage());
		assert (entity.find(Garage.class, g.getId_garage()) == null);
		assert (entity.find(Address.class, aa.getId_address()) == null);
		for(Box b : lbox) {
			assert(entity.find(Box.class, b.getId_box()) == null);
		}
	}

}
