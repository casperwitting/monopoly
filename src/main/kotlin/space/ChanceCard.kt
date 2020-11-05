package space

import board.Space

class ChanceCard : Space {
    override var description = "KANSKAART"
    override var price = 0
    private val cards = listOf(
        Card(
            description = "Belasting, betaal",
            price = -15
        ),
        Card(
            description = "Geluk met divident, je ontvangt",
            price = 100
        ),
        Card(
            description = "Je hebt een kruiswoordpuzzel wedstrijd gewonnen en ontvangt",
            price = 50
        )
    )

    fun pickCard(): Card {
        return cards.random()
    }

}
