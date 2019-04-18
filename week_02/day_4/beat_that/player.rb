require("pry")

class Player
	attr_reader :name
	attr_accessor :score

	def initialize(name)
		@name = name
		@score = 0
	end

	def roll(dice)
		# create results array
		results = []

		# loop through
		for die in dice
			# roll each die
			result = die.roll()

			# push the result to results
			results.push(result)
		end

		return results
	end
end
