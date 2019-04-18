import behaviours.IStrategy;
import org.junit.Before;
import org.junit.Test;
import players.CPU;
import strategies.AggressiveStrategy;
import strategies.DefensiveStrategy;

import static org.junit.Assert.assertEquals;

public class CPUTest {
    CPU cpu;

    @Before
    public void setUp() throws Exception {
        IStrategy aggressive = new AggressiveStrategy();
        cpu = new CPU(aggressive);
    }

    @Test
    public void canMakeMove() {
        String result = cpu.makeMove();
        assertEquals("I'm making an aggressive move!", result);
    }

    @Test
    public void canChangeStrategy() {
        IStrategy defensive = new DefensiveStrategy();
        cpu.setStrategy(defensive);
        String result = cpu.makeMove();
        assertEquals("I'm making a defensive move!", result);
    }
}
