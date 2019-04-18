package strategies;

import behaviours.IStrategy;

public class StrategyFactory {
    public IStrategy getStrategy(String requested) {
        if(requested.equalsIgnoreCase("aggressive")){
            return new AggressiveStrategy();

        }else if(requested.equalsIgnoreCase("defensive")){
            return new DefensiveStrategy();
        }

        return null;
    }
}
