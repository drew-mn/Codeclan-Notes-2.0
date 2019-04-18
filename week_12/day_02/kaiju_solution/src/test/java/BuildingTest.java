import buildings.Skyscraper;
import kaiju.Mothra;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuildingTest {

    Skyscraper skyscraper;
    Mothra mothra;

    @Before
    public void setup(){
        skyscraper = new Skyscraper("70 Renfrew Street");
        mothra = new Mothra("Neville");
    }

    @Test
    public void canGetStructuralIntegrity(){
        assertEquals(100, skyscraper.getStructuralIntegrity());
    }

    @Test
    public void buildingCanTakeDamage(){
        mothra.attack(skyscraper);
        assertEquals(50, skyscraper.getStructuralIntegrity());
    }


}
