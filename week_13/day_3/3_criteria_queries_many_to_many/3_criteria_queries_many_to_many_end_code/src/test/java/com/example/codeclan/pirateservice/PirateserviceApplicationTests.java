package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.PirateRepository;
import com.example.codeclan.pirateservice.repository.RaidRepository.RaidRepository;
import com.example.codeclan.pirateservice.repository.ShipRepository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void createPirateAndShipThenSave(){

		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);
	}

	@Test
	public void createPirateAndRaidThenSave(){
		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Raid raid = new Raid("Tortuga", 100);
		raidRepository.save(raid);

		jack.addRaid(raid);
		raid.addPirate(jack);
		raidRepository.save(raid);

	}

	@Test
	public void canFindAllPiratesForShip(){
		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Pirate james = new Pirate("james", "mcgill", 45, dutchman);
		pirateRepository.save(james);

		List<Pirate> foundPirates = shipRepository.findAllPiratesForShip(dutchman);
	}

	@Test
	public void canFindAllPiratesForRaid(){

		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Raid raid = new Raid("Tortuga", 100);
		raidRepository.save(raid);

		jack.addRaid(raid);
		pirateRepository.save(jack);


		Pirate james = new Pirate("james", "mcgill", 45, dutchman);
		pirateRepository.save(james);
		raid.addPirate(james);
		raidRepository.save(raid);


		List<Pirate> foundPiratesForRaid = raidRepository.getPiratesForRaid(raid);
		assertEquals(foundPiratesForRaid.size(), 2);
		assertEquals(foundPiratesForRaid.get(0).getFirstName(), "jack");
		assertEquals(foundPiratesForRaid.get(1).getFirstName(), "james");
	}


}
