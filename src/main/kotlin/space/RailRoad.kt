package space

import player.Player

class RailRoad(
    override var description: String
) : Property {
    override lateinit var owner: Player
    override lateinit var group: PropertyGroup
    override var price = 200

    override fun isOwned(): Boolean {
        return this::owner.isInitialized
    }
}