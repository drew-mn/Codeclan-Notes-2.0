class Game
	attr_reader :winner

	def initialize(players, dice, ui)
		@players = players
		@dice = dice
		@winner = nil
		@ui = ui
	end

	def start()
		@ui.print_welcome()
		@ui.print_players(@players)

		# While no-one has won
		while @winner == nil
			# Assign current + previous players
			current_player = @players[0]
			previous_player = @players[1]

			# Roll dice for current player
			current_player_roll = current_player.roll(@dice)

			# Assign score for current player
			current_player.score = calculate_score(current_player_roll)

			@ui.print_roll(current_player)

			# Decide whether to assign a winner
			if current_player.score > previous_player.score
				@players.rotate!()
			else
				@winner = previous_player
				@ui.print_winner(@winner)
			end
		end
	end

	def calculate_score(numbers)
		return numbers
						.sort
						.reverse
						.join
						.to_i
	end
end
