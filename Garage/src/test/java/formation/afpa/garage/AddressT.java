package formation.afpa.garage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class AddressT {
	
	@Autowired
	private TestEntityManager entity;
	@Autowired
	private AddressRepo ar;
	private Address a;
	
	@Before
	public void setUp() {
		Address ad = new Address("12 rue des chaussettes", "64000", "Pau");
		entity.persist(ad);
		a = ad;
	}
	
	@Test
	public void createAddress() {
		Address c = new Address("1 rue de luit", "01000", "Ville");
		ar.save(c);
		assertNotNull(ar.findById(a.getId_address()));
	}

	@Test
	public void getAddressId() {
		Address i = ar.findById(a.getId_address()).get();
		assertNotNull(i);
	}
	
	@Test
	public void updateAddress() {
		Address i = a;
		i.setAdresse("siufdhgufdhsgh");
		ar.save(i);
		assertEquals(i.getAdresse(), ar.findById(a.getId_address()).get().getAdresse());
	}

	@Test
	public void deleteAddress() {
		ar.delete(entity.find(Address.class, a.getId_address()));
		assert (entity.find(Address.class, a.getId_address()) == null);
	}

	@Test
	public void deleteAddressId() {
		ar.deleteById(a.getId_address());
		assert (entity.find(Address.class, a.getId_address()) == null);
	}
}