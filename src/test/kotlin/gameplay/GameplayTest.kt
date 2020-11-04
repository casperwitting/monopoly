package gameplay

import board.Space
import board.space.HousableProperty
import board.space.Property
import gameplay.rules.LandOnSpaceRuleFactory
import gameplay.rules.SpaceRule
import gameplay.rules.PassStartRule
import org.junit.Test
import player.Player

class GameplayTest {
    @Test
    fun testGameplay() {
        val gameFactory = GameFactory()
        val game = gameFactory.newGame()

        println("------------------------------")
        println("|                            |")
        println("|          Monopoly          |")
        println("|                            |")
        println("------------------------------")

        for (i in 0..20) {
            for (player: Player in game.players) {
                simulateTurn(game, player)
            }
        }

        printGameState(game)

        breaks(5)
    }

    private fun simulateTurn(game: Game, player: Player, eyes: Int? = null) {
        val landActionFactory = LandOnSpaceRuleFactory()
        val passStartRule = PassStartRule()

        val dice = Dice();
        val amountRolled = dice.roll()
        printGameStep(player.name + " rolt de dobbelsteen... " + amountRolled)

        for (i in 1..amountRolled) {
            if (player.token.position + 1 == game.board.spaces.count()) {
                player.token.position = -1
            }

            player.token.position++
            val currentSpace = game.board.spaces[player.token.position]

            if (passStartRule.ruleApplies(currentSpace, player)) {
                printGameStep("Speler gaat langs start en ontvangt 200!")
                passStartRule.execute(currentSpace, player, game.bank, amountRolled)
            }
            // TODO: 02/11/2020 add rolledAmount to SpaceRule interface 
            // TODO: 02/11/2020 make data class for PlayMeta? Containing AmountRolled, CurrentSpace, Player, Bank
            if (i == amountRolled) {
                for (spaceRule: SpaceRule in landActionFactory.getActions()) {
                    if (spaceRule.ruleApplies(currentSpace, player)) {
                        spaceRule.execute(currentSpace, player, game.bank, amountRolled)
                    }
                }

                breaks(2)
            }
        }
    }

    private fun printGameState(game: Game) {
        for ((index, space: Space) in game.board.spaces.withIndex()) {
            block(game, space, index)
        }
        println("---------------------------")
    }

    private fun block(game: Game, space: Space, index: Int) {
        fun addSpaces(amount: Int): String {
            var result = "";
            for (i in 0..amount) {
                result += " ";
            }
            return result
        }

        fun center(s: String): String {
            val stringLength = s.length
            var marginStart = (23 - stringLength) / 2
            var marginEnd = marginStart
            if (stringLength % 2 == 0) {
                marginEnd++
            }

            return addSpaces(marginStart) + s + addSpaces(marginEnd)
        }

        println("---------------------------")
        println("|" + center(space.description) + "|  " + getOwnerStatus(space))
        println("|" + center(space.price.toString()) + "|  " + getHouseStatus(space))
        println("|" + center(getToken(game.players, index)) + "|")
    }

    private fun getToken(players: MutableList<Player>, index: Int): String {
        var result = ""
        for (player: Player in players) {
            if (player.token.position == index) {
                result += player.token.name
            }
        }
        return result
    }

    private fun getHouseStatus(space: Space): String {
        if (space is HousableProperty && space.isOwned()) {
            var result = ""
            for (i in 1..space.buildings.count()) {
                result += "🏠"
                // TODO: 23/10/2020 add hotel character "🏠🏨"
            }
            return result
        }

        return ""
    }

    private fun getOwnerStatus(space: Space): String {
        if (space is Property && space.isOwned()) {
            return "Eigendom van: " + space.owner.name
        }

        return ""
    }


    private fun printGameStep(s: String) {
        println("~~~> " + s)
    }

    private fun breaks(amount: Int) {
        var result = "";
        for (i in 1..amount) {
            result += "\n"
        }

        print(result)
    }
}