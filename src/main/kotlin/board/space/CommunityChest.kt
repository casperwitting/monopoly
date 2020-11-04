package board.space

import board.Space

class CommunityChest : Space {
    override var description = "ALGEMEEN FONDS"
    override var price = 0
    private val cards = listOf(
        Card(
            description = "Bankfout in jouw voordeel, je ontvangt",
            price = 200
        ),
        Card(
            description = "Doktersvergoeding, je betaalt",
            price = -50
        ),
        Card(
            description = "Uit de verkoop van aandelen ontvang je",
            price = 50
        ),
        Card(
            description = "Vakantiefonds rijpt, je ontvangt",
            price = 100
        ),
        Card(
            description = "Erfenis, je ontvangt",
            price = 100
        )
    )

    fun pickCard(): Card {
        return cards.random()
    }

}
