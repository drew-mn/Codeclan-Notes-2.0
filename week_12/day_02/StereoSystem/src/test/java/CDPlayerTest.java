import components.CDPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDPlayerTest {

    CDPlayer cdPlayer;

    @Before
    public void setUp() {
        cdPlayer = new CDPlayer("Sony", "MultiDisk", 4);
    }

    @Test
    public void canPlayCD() {
        assertEquals("CD - Playing: Eiffle 65", cdPlayer.play("Eiffle 65"));
    }
}
