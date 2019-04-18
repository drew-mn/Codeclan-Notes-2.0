import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MammalTest {

    Mammal mammal;

    @Before
    public void setup(){
        mammal = new Mammal();
    }

    @Test
    public void canTalk(){
        assertEquals("chatter", mammal.talk());
    }

    @Test
    public void canEat(){
        assertEquals("Nom nom", mammal.eat());
    }
}
