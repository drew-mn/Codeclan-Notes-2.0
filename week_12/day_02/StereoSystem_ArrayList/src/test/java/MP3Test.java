import components.*;
import devices.Stereo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MP3Test {

    Stereo stereo;
    Radio radio;
    CDPlayer cdPlayer;
    RecordDeck recordDeck;
    MP3Player mp3Player;

    @Before
    public void setUp() {
        cdPlayer = new CDPlayer("Sony", "MultiDisk", 4);
        radio = new Radio("Sony DAB", "slim");
        recordDeck = new RecordDeck("Pioneer", "PL-990");
        ArrayList<Component> components = new ArrayList<Component>();
        components.add(cdPlayer);
        components.add(radio);
        components.add(recordDeck);
        stereo = new Stereo("Boombox 100", components);        mp3Player = new MP3Player("Apple", "ipod");
    }

    @Test
    public void canConnectToStereo() {
        assertEquals("Connected to - Boombox 100", mp3Player.connect(stereo));
    }
}
