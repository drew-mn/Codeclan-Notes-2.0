import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    Animal animal;

    @Before
    public void setup(){
        animal = new Animal();
    }

    @Test
    public void canEat(){
        assertEquals("Nom nom", animal.eat());
    }

    @Test
    public void canBreathe(){
        assertEquals("Breathing sounds", animal.breathe());
    }

}
