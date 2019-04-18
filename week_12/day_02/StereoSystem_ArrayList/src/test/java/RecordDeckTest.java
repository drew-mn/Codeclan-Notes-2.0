import components.RecordDeck;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordDeckTest {

    RecordDeck recordDeck;

    @Before
    public void setUp() {
        recordDeck = new RecordDeck("Pioneer", "PL-990");
    }

    @Test
    public void canPlayRecord() {
        assertEquals("Record Deck Playing - SGT PEPPER'S LONELY HEARTS CLUB BAND", recordDeck.play("SGT PEPPER'S LONELY HEARTS CLUB BAND"));
    }
}
