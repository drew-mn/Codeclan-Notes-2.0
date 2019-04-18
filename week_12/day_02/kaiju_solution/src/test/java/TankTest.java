import kaiju.Godzilla;
import org.junit.Before;
import org.junit.Test;
import vehicles.Tank;

import static org.junit.Assert.assertEquals;

public class TankTest {

    Tank tank;
    Godzilla godzilla;

    @Before
    public void setup(){
        tank = new Tank("Panzer");
        godzilla = new Godzilla("Brian");
    }

    @Test
    public void canGetType() {
        assertEquals("Panzer", tank.getType());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(100, tank.getHealthValue());
    }

    @Test
    public void canGetAttackValue() {
        assertEquals(50, tank.getAttackValue());
    }

    @Test
    public void tankCanAttackGodzilla(){
        tank.attack(godzilla);
        assertEquals(50, godzilla.getHealthValue());
    }
}
