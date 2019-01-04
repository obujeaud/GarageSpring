package formation.afpa.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
public class BoxT {
	
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private BoxRepo br;
	private Box box;
	@SuppressWarnings("unused")
	private Location l;
	@SuppressWarnings("unused")
	private Garage gg;
	
	@Before
	public void setUp() {
		Garage g = new Garage("Gtest", new Address("2 rue du slip", "83510", "Lorgues"));
		Box b = new Box(15, 11.0);
		Vehicule v = new Vehicule("Renault", "Clio", new Date(1993), "CCC-12-DDD");
		Location ll = new Location(b, v, 15, new Date(2018), new Date(2019));
		b.setLoc(ll);
		g.ajoutBox(b);
		b.setG(g);
		entity.persist(g);
		entity.persist(ll);
		entity.persist(b);
		entity.persist(v);
		box = b;
		l = ll;
		gg = g;
	}
	
	@Test
	public void createBox() {
		Box c = new Box(2, 2.0);
		br.save(c);
		assertNotNull(br.findById(c.getId_box()));
	}

	@Test
	public void getBoxId() {
		Box i = br.findById(box.getId_box()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateBox() {
		Box i = box;
		i.setNumEmplacement(30);
		br.save(i);
		assertEquals(i.getNumEmplacement(), br.findById(box.getId_box()).get().getNumEmplacement());
	}

	@Test
	public void deleteBox() {
		Long id = box.getId_box();
		br.delete(entity.find(Box.class, box.getId_box()));
		assertTrue(!br.findById(id).isPresent());
	}

	@Test
	public void deleteBoxId() {
		Long id = box.getId_box();
		br.deleteById(entity.find(Box.class, box.getId_box()).getId_box());
		assertTrue(!br.findById(id).isPresent());
	}

}
