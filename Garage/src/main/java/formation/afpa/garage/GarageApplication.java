package formation.afpa.garage;

import java.sql.Date;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GarageApplication implements CommandLineRunner {
	@Autowired
	GarageService serv;
	Log l = LogFactory.getLog(GarageApplication.class);

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(GarageApplication.class).headless(false)
				.run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		serv.savePerson(new Person("Olivier", "Bujeaud"));
		serv.savePerson(new Person("Emmanuelle", "Bujeaud"));
		serv.savePerson(new Person("Sebastien", "Bujeaud"));

		serv.saveVehicule(new Vehicule("Renault", "Kangoo", new Date(2018), "AAA-54-BBB"));
		serv.saveVehicule(new Vehicule("Renault", "Clio", new Date(1993), "CCC-55-DDD"));
		serv.saveVehicule(new Vehicule("Renault", "R5", new Date(1990), "EEE-56-FFF"));
		serv.saveVehicule(new Vehicule("Renault", "4L", new Date(1975), "GGG-57-HHH"));

		serv.getPersonId(2).ajoutVoiture(serv.getVoitureId(1));
		serv.getPersonId(2).ajoutVoiture(serv.getVoitureId(2));
		serv.getPersonId(1).ajoutVoiture(serv.getVoitureId(3));
		serv.getPersonId(3).ajoutVoiture(serv.getVoitureId(4));

		serv.saveAddress(new Address("2 rue de la Franquette", "83000", "Toulon"));
		serv.saveAddress(new Address("palissade du jambon", "06000", "Nice"));
		serv.saveGarage(new Garage("Garage1", serv.getAddressId(1)));
		serv.getPersonId(2).ajoutGarage(serv.getGarageId(1));
		serv.saveGarage(new Garage("Garage2", serv.getAddressId(2)));

		serv.saveBox(new Box(10, 40.0));
		serv.saveBox(new Box(11, 45.0));
		serv.saveBox(new Box(12, 30.0));
		serv.saveBox(new Box(13, 35.0));

		serv.saveBox(new Box(150, 4000.0));
		serv.saveBox(new Box(250, 4005.0));
		serv.saveBox(new Box(300, 3000.0));
		serv.saveBox(new Box(710, 3005.0));

		serv.ajoutBoxGarage(1, 1);
		serv.ajoutBoxGarage(1, 2);
		serv.ajoutBoxGarage(1, 3);
		serv.ajoutBoxGarage(1, 4);

		serv.ajoutBoxGarage(2, 5);
		serv.ajoutBoxGarage(2, 6);
		serv.ajoutBoxGarage(2, 7);
		serv.ajoutBoxGarage(2, 8);

		serv.saveLocation(new Location(serv.getBoxId(1), serv.getVehiculeId(1), 150, new Date(1980 - 02 - 01),
				new Date(1982 - 02 - 01)));
		serv.saveLocation(new Location(serv.getBoxId(2), serv.getVehiculeId(4), 300, new Date(2000), new Date(2001)));

		serv.saveLocation(new Location(serv.getBoxId(6), serv.getVehiculeId(2), 1500, new Date(1900), new Date(1900)));
		serv.saveLocation(new Location(serv.getBoxId(8), serv.getVehiculeId(3), 1500, new Date(1900), new Date(1900)));

		l.info(serv.getGarageId(2).toString());

		serv.getPersonId(1).ajoutVoiture(serv.getVoitureId(3));

	}
}