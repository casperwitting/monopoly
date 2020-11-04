package board.space

import board.Space

class FreeParking(override var description: String) : Space {
    override var price: Int = 0
}
