package formation.afpa.garage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GarageService {
	@Autowired
	AddressRepo ar;
	@Autowired
	BoxRepo br;
	@Autowired
	GarageRepo gr;
	@Autowired
	LocationRepo lr;
	@Autowired
	PersonRepo pr;
	@Autowired
	VehiculeRepo vr;
	@Autowired
	VoitureRepo vrr;

	public void saveAddress(Address a) {
		ar.save(a);
	}

	public void saveBox(Box b) {
		br.save(b);
	}

	public void saveGarage(Garage g) {
		gr.save(g);
	}

	public void saveLocation(Location l) {
		lr.save(l);
		l.getlBox().setLoc(l);
		l.getlVehicule().setLc(l);
	}

	public void savePerson(Person p) {
		pr.save(p);
	}

	public void saveVehicule(Vehicule v) {
		vr.save(v);
	}

	public void saveVoiture(Voiture v) {
		vrr.save(v);
	}

	public Address getAddressId(long id) {
		return ar.findById(id).get();
	}

	public Box getBoxId(long id) {
		return br.findById(id).get();
	}

	public Garage getGarageId(long id) {
		return gr.findById(id).get();
	}

	public Location getLocationId(long id) {
		return lr.findById(id).get();
	}

	public Person getPersonId(long id) {
		return pr.findById(id).get();
	}

	public Vehicule getVehiculeId(long id) {
		return vr.findById(id).get();
	}

	public Voiture getVoitureId(long id) {
		return vrr.findById(id).get();
	}

	public void deleteAddress(Address a) {
		ar.delete(a);
	}

	public void deleteGarage(Garage a) {
		gr.delete(a);
	}

	public void deleteBox(Box a) {
		br.delete(a);
	}

	public void deleteLocation(Location a) {
		lr.delete(a);
	}

	public void deletePerson(Person a) {
		pr.delete(a);
	}

	public void deleteVehicule(Vehicule a) {
		vr.delete(a);
	}

	public void deleteVoiture(Voiture a) {
		vrr.delete(a);
	}

	public void deleteAddressId(long id) {
		ar.deleteById(id);
	}

	public void deleteGarageId(long id) {
		gr.deleteById(id);
	}

	public void deleteBoxId(long id) {
		br.deleteById(id);
	}

	public void deleteLocationId(long id) {
		lr.deleteById(id);
	}

	public void deletePersonId(long id) {
		pr.deleteById(id);
	}

	public void deleteVehiculeId(long id) {
		vr.deleteById(id);
	}

	public void deleteVoitureId(long id) {
		vrr.deleteById(id);
	}
	
	public void ajoutBoxGarage(long id, long id2) {
		getGarageId(id).ajoutBox(getBoxId(id2));
	}
	
}
