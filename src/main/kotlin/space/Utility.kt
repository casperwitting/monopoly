package space

import player.Player

class Utility(
    override var description: String
) : Property {
    override lateinit var owner: Player
    override lateinit var group: PropertyGroup
    override var price = 150

    override fun isOwned(): Boolean {
        return this::owner.isInitialized
    }
}
