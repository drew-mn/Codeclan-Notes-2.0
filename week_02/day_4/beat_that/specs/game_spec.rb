require("minitest/autorun")
require("minitest/rg")
require_relative("../player")
require_relative("../die")
require_relative("../game")
require_relative("../DummyUI")

class GameTest < Minitest::Test
	def setup
		ui = DummyUI.new()

		player1 = Player.new("John")
		player2 = Player.new("Colibu")

		die1 = Die.new()
		die2 = Die.new()
		die3 = Die.new()
		die4 = Die.new()

		dice = [die1, die2, die3, die4]

		@game = Game.new([player1, player2], dice, ui)
	end

	def test_game_logic
		# Arrange
		input = [5, 1, 6, 2]
		expected = 6521

		# Act
		result = @game.calculate_score(input)

		# Assert
		assert_equal(expected, result)
	end

	def test_game_loop
		@game.start()

		assert(@game.winner != nil)
		assert_equal(Player, @game.winner.class)
	end
end
