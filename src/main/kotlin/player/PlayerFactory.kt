package player

import payment.Bill

class PlayerFactory {
    private val playerMoneyMap = mapOf(
        500 to 2,
        100 to 4,
        50 to 1,
        20 to 1,
        10 to 2,
        5 to 1,
        1 to 5
    )

    fun createPlayer(name: String, token: String): Player {
        val player = Player(name)

        player.bills.addAll(convertMapToBills(playerMoneyMap))

        return player
    }



    private fun convertMapToBills(map: Map<Int, Int>): Collection<Bill> {
        val list = mutableListOf<Bill>()

        for (m in map) {
            repeat(m.value) {
                list.add(Bill(m.key))
            }
        }

        return list;
    }

}
