class CommandLineUi
    def print_welcome()
        p "Welcome to BEAT THAT!"
    end

    def print_players(players)
        p "It's #{players[0].name} vs. #{players[1].name}"
    end

    def print_roll(player)
        p "#{player.name} has rolled #{player.score}"
    end

    def print_winner(player)
        p "#{player.name} has won with #{player.score}!"
    end
end