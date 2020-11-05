package board

import space.*

class BoardFactory {
    fun makeBoard(): Board {
        val board = Board()

        val ourVillageGroup = Group()
        val dorpsStraat = Street("DORPSTRAAT", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        val brink = Street("BRINK", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        val vissteeg = Street("VISSTEEG", 60, 2, 10, 30, 90, 160, 250, 50, 30)
        ourVillageGroup.addProperties(listOf(dorpsStraat, brink, vissteeg))

        val stations = Group()
        val stationZuid = RailRoad("STATION ZUID")
        val stationWest = RailRoad("STATION WEST")
        val stationNoord = RailRoad("STATION NOORD")
        val stationOost = RailRoad("STATION OOST")
        stations.addProperties(listOf(stationZuid, stationWest, stationNoord, stationOost))

        val arnhem = Group()
        val steenstraat = Street("STEENSTRAAT", 100, 2, 10, 30, 90, 160, 250, 50, 30)
        val ketelStraat = Street("KETELSTRAAT", 100, 2, 10, 30, 90, 160, 250, 50, 30)
        val velperPlein = Street("VELPERPLEIN", 100, 2, 10, 30, 90, 160, 250, 50, 30)
        val koreMarkt = Street("KOREMARKT", 120, 2, 10, 30, 90, 160, 250, 50, 30)
        arnhem.addProperties(listOf(steenstraat, ketelStraat, velperPlein, koreMarkt))

        val utilities = Group()
        val gasfabriek = Utility("GASFABRIEK")
        val elektriciteit = Utility("ELEKTRICITEITSBEDRIJF")
        val waterleiding = Utility("WATERLEIDING")
        utilities.addProperties(listOf(elektriciteit, gasfabriek, waterleiding))

        val haarlem = Group()
        val bartelorisStraat = Street("BARTELORISSTRAAT", 140, 2, 10, 30, 90, 160, 250, 50, 30)
        val zijlweg = Street("ZIJLWEG", 140, 2, 10, 30, 90, 160, 250, 50, 30)
        val houtStraat = Street("HOUTSTRAAT", 140, 2, 10, 30, 90, 160, 250, 50, 30)
        val spaarne = Street("SPAARNE", 160, 2, 10, 30, 90, 160, 250, 50, 30)
        haarlem.addProperties(listOf(bartelorisStraat, zijlweg, houtStraat, spaarne))

        val utrecht = Group()
        val neude = Street("NEUDE", 180, 2, 10, 30, 90, 160, 250, 50, 30)
        val biltStraat = Street("BILTSTRAAT", 180, 2, 10, 30, 90, 160, 250, 50, 30)
        val vreeburg = Street("VREEBURG", 200, 2, 10, 30, 90, 160, 250, 50, 30)
        val domPlein = Street("DOMPLEIN", 200, 2, 10, 30, 90, 160, 250, 50, 30)
        utrecht.addProperties(listOf(neude, biltStraat, vreeburg, domPlein))

        val groningen = Group()
        val kerkhof = Street("A-KERKHOF", 220, 2, 10, 30, 90, 160, 250, 50, 30)
        val groteMarkt = Street("GROTE MARKT", 220, 2, 10, 30, 90, 160, 250, 50, 30)
        val hereStraat = Street("HERESTRAAT", 240, 2, 10, 30, 90, 160, 250, 50, 30)
        val turfTorenStraat = Street("TURFTORENSTRAAT", 240, 2, 10, 30, 90, 160, 250, 50, 30)
        groningen.addProperties(listOf(kerkhof, groteMarkt, hereStraat, turfTorenStraat))

        val sGravenhage = Group()
        val spui = Street("SPUI", 260, 2, 10, 30, 90, 160, 250, 50, 30)
        val plein = Street("PLEIN", 260, 2, 10, 30, 90, 160, 250, 50, 30)
        val langePoten = Street("LANGE POTEN", 280, 2, 10, 30, 90, 160, 250, 50, 30)
        val binnenHof = Street("BINNENHOF", 280, 2, 10, 30, 90, 160, 250, 50, 30)
        sGravenhage.addProperties(listOf(spui, plein, langePoten, binnenHof))

        val rotterdam = Group()
        val hofPlein = Street("HOFPLEIN", 300, 2, 10, 30, 90, 160, 250, 50, 30)
        val blaak = Street("BLAAK", 300, 2, 10, 30, 90, 160, 250, 50, 30)
        val coolSingel = Street("COOLSINGEL", 300, 2, 10, 30, 90, 160, 250, 50, 30)
        val heemRaads = Street("HEEMRAADS", 320, 2, 10, 30, 90, 160, 250, 50, 30)
        rotterdam.addProperties(listOf(hofPlein, blaak, coolSingel, heemRaads))

        val amsterdam = Group()
        val leidseStraat = Street("LEIDSESTRAAT", 350, 2, 10, 30, 90, 160, 250, 50, 30)
        val kalverStraat = Street("KALVERSTRAAT", 350, 2, 10, 30, 90, 160, 250, 50, 30)
        val dam = Street("DAM", 400, 2, 10, 30, 90, 160, 250, 50, 30)
        amsterdam.addProperties(listOf(leidseStraat, kalverStraat, dam))

        board.spaces.add(Start())
        board.spaces.add(dorpsStraat)
        board.spaces.add(CommunityChest())
        board.spaces.add(brink)
        board.spaces.add(vissteeg)
        board.spaces.add(IncomeTax())
        board.spaces.add(stationZuid)
        board.spaces.add(steenstraat)
        board.spaces.add(ketelStraat)
        board.spaces.add(ChanceCard())
        board.spaces.add(gasfabriek)
        board.spaces.add(velperPlein)
        board.spaces.add(koreMarkt)
        board.spaces.add(FreeParking("SLECHTS OP BEZOEK"))
        board.spaces.add(bartelorisStraat)
        board.spaces.add(zijlweg)
        board.spaces.add(elektriciteit)
        board.spaces.add(houtStraat)
        board.spaces.add(spaarne)
        board.spaces.add(stationWest)
        board.spaces.add(neude)
        board.spaces.add(CommunityChest())
        board.spaces.add(biltStraat)
        board.spaces.add(vreeburg)
        board.spaces.add(domPlein)
        board.spaces.add(FreeParking("VRIJ PARKEREN"))
        board.spaces.add(kerkhof)
        board.spaces.add(ChanceCard())
        board.spaces.add(groteMarkt)
        board.spaces.add(hereStraat)
        board.spaces.add(turfTorenStraat)
        board.spaces.add(stationNoord)
        board.spaces.add(spui)
        board.spaces.add(plein)
        board.spaces.add(waterleiding)
        board.spaces.add(langePoten)
        board.spaces.add(binnenHof)
//        board.spaces.add(Jail())
        board.spaces.add(hofPlein)
        board.spaces.add(blaak)
        board.spaces.add(coolSingel)
        board.spaces.add(CommunityChest())
        board.spaces.add(heemRaads)
        board.spaces.add(stationOost)
        board.spaces.add(ChanceCard())
        board.spaces.add(leidseStraat)
        board.spaces.add(kalverStraat)
        board.spaces.add(IncomeTax())
        board.spaces.add(dam)

        return board;
    }
}

