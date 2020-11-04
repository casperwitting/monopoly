package gameplay.rules

class LandOnSpaceRuleFactory {
    fun getActions() : MutableList<SpaceRule> {
        return mutableListOf(
            LandOnOwnPropertyRule(),
            LandOnUnownedPropertyRule(),
            LandOnCommunityChestRule(),
            LandOnOtherPlayersPropertyRule(),
            LandOnIncomeTaxRule(),
            LandOnChanceCardRule()
        )
    }
}