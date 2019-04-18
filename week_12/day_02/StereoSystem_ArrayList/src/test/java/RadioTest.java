import components.Radio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    Radio radio;

    @Before
    public void setUp() {
        radio = new Radio("Sony DAB", "slim");
    }

    @Test
    public void canTuneToStation() {
        assertEquals("Tuned to Radio 1", radio.tune("Radio 1"));
    }
}
