require("minitest/autorun")
require("minitest/rg")
require_relative("../die")
require_relative("../player")

class PlayerTest < Minitest::Test
	def setup
		@player = Player.new("John")

		die1 = Die.new()
		die2 = Die.new()
		die3 = Die.new()
		die4 = Die.new()

		@dice = [die1, die2, die3, die4]
	end

	def test_get_name
		assert_equal("John", @player.name)
	end

	def test_player_starts_at_zero
		assert_equal(0, @player.score)
	end

	def test_player_can_roll
		# act
		player_roll = @player.roll(@dice)

		# assert
		assert_equal(4, player_roll.length())

		assert_equal(Integer, player_roll[0].class)
	end

	def test_can_set_score
		@player.score = 5555
		assert_equal(5555, @player.score)
	end
end
