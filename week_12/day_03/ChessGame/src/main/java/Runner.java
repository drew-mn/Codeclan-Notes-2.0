import behaviours.IStrategy;
import players.CPU;
import players.Player;
import players.User;
import strategies.StrategyFactory;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Please enter player 1 name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        User player1 = new User(name);

        GameState state = GameState.getInstance();
        state.addPlayer(player1);

        System.out.println("What type of CPU do you want to play against?");
        String requestedStrategy = scanner.nextLine();

        StrategyFactory factory = new StrategyFactory();
        IStrategy strategy = factory.getStrategy(requestedStrategy);

        Player cpu = new CPU(strategy);

        state.addPlayer(cpu);

        System.out.println(state.startGame());
    }
}
