import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    Human human = new Human();

    @Test
    public void canWalk(){
        assertEquals("I'm walking!", human.walk());
    }
}
