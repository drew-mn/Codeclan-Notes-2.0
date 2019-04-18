import components.Component;
import devices.Stereo;
import components.CDPlayer;
import components.Radio;
import components.RecordDeck;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StereoTest {

    Stereo stereo;
    Radio radio;
    CDPlayer cdPlayer;
    RecordDeck recordDeck;

    @Before
    public void setUp() {
        cdPlayer = new CDPlayer("Sony", "MultiDisk", 4);
        radio = new Radio("Sony DAB", "slim");
        recordDeck = new RecordDeck("Pioneer", "PL-990");
        ArrayList<Component> components = new ArrayList<Component>();
        components.add(cdPlayer);
        components.add(radio);
        components.add(recordDeck);
        stereo = new Stereo("Boombox 100", components);
    }

    @Test
    public void canTuneRadio() {
        assertEquals("Tuned to Radio 1", stereo.useComponent("Radio 1", radio));
    }

    @Test
    public void canPlayCD() {
        assertEquals("CD - Playing: Eiffle 65", stereo.useComponent("Eiffle 65", cdPlayer));
    }

    @Test
    public void canPlayRecord() {
        assertEquals("Record Deck Playing - SGT PEPPER'S LONELY HEARTS CLUB BAND", stereo.useComponent("SGT PEPPER'S LONELY HEARTS CLUB BAND", recordDeck));
    }

    @Test
    public void canTurnUp() {
        stereo.turnItUp();
        assertEquals(1, stereo.getCurrentVolume());
    }

    @Test
    public void canTurnDown() {
        stereo.turnItUp();
        stereo.turnItUp();
        stereo.turnItDown();
        assertEquals(1, stereo.getCurrentVolume());
    }

    @Test
    public void cannotTurnSoundUpBeyondMax() {
        stereo.setCurrentVolume(10);
        stereo.turnItUp();
        assertEquals(10, stereo.getCurrentVolume());
    }

    @Test
    public void cannotTurnSoundDownBelowZero() {
        stereo.turnItDown();
        assertEquals(0, stereo.getCurrentVolume());
    }


}
