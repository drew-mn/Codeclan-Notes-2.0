import behaviours.IStrategy;
import org.junit.Before;
import org.junit.Test;
import strategies.AggressiveStrategy;
import strategies.StrategyFactory;

public class StrategyFactoryTest {
    StrategyFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new StrategyFactory();
    }

    @Test
    public void canGetStrategy() {
        String requested = "aggressive";
        IStrategy strategy = factory.getStrategy(requested);

        assert(strategy instanceof AggressiveStrategy);
    }
}
