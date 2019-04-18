import kaiju.Godzilla;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GodzillaTest {

    Godzilla godzilla;

    @Before
    public void setup(){
        godzilla = new Godzilla("Brian");
    }

    @Test
    public void canGetName(){
        assertEquals("Brian", godzilla.getName());
    }

    @Test
    public void canGetHealthValue(){
        assertEquals(100, godzilla.getHealthValue());
    }

    @Test
    public void canGetAttackValue(){
        assertEquals(100, godzilla.getAttackValue());
    }

    @Test
    public void canRoar(){
        assertEquals("Roar I'm Brian", godzilla.roar());
    }

    @Test
    public void canMove(){
        assertEquals("Stomp stomp stomp", godzilla.move());
    }

}
