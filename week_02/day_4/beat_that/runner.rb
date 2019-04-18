require_relative("./player")
require_relative("./die")
require_relative("./game")
require_relative("./CommandLineUi")

ui = CommandLineUi.new()

player1 = Player.new("John")
player2 = Player.new("Colibu")

die1 = Die.new()
die2 = Die.new()
die3 = Die.new()
die4 = Die.new()

dice = [die1, die2, die3, die4]

@game = Game.new([player1, player2], dice, ui)

@game.start()
