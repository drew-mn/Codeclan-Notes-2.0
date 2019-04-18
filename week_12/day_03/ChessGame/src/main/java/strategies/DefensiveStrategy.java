package strategies;

import behaviours.IStrategy;

public class DefensiveStrategy implements IStrategy {
    public String makeMove() {
        return "I'm making a defensive move!";
    }
}
