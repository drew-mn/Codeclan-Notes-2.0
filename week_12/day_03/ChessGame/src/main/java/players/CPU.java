package players;

import behaviours.IStrategy;

public class CPU extends Player {
    private IStrategy strategy;

    public CPU(IStrategy strategy) {
        this.strategy = strategy;
    }

    public String makeMove() {
        return this.strategy.makeMove();
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }
}
