require("minitest/autorun")
require("minitest/rg")
require_relative("../die")

class DieTest < Minitest::Test
	def setup
		@die = Die.new()
	end

	def test_die_output
		1000.times do |x|
			result = @die.roll()
			expected = [1,2,3,4,5,6]
			assert(expected.include?(result))
		end
	end
end
