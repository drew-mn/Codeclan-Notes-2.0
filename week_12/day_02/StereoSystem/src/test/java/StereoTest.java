import devices.Stereo;
import components.CDPlayer;
import components.Radio;
import components.RecordDeck;
import org.junit.Before;
import org.junit.Test;

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
        stereo = new Stereo("Boombox 100", radio, recordDeck, cdPlayer);
    }

    @Test
    public void canTuneRadio() {
        assertEquals("Tuned to Radio 1", stereo.tuneRadio("Radio 1"));
    }

    @Test
    public void canPlayCD() {
        assertEquals("CD - Playing: Eiffle 65", stereo.playCD("Eiffle 65"));
    }

    @Test
    public void canPlayRecord() {
        assertEquals("Record Deck Playing - SGT PEPPER'S LONELY HEARTS CLUB BAND", stereo.playRecord("SGT PEPPER'S LONELY HEARTS CLUB BAND"));
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
