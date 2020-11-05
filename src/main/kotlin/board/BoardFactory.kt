package board

import space.*
import space.housableproperty.Street
import space.housableproperty.StreetRentScheme
import space.property.Group
import space.property.RailRoad
import space.property.Utility

class BoardFactory {
    fun makeBoard(): Board {
        val board = Board()

        val ourVillageGroup = Group()
        val dorpsStraat = Street("DORPSTRAAT", 60, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val brink = Street("BRINK", 60, 50, 30, StreetRentScheme( 2, 10, 30, 90, 160, 250))
        val vissteeg = Street("VISSTEEG", 60,  50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        ourVillageGroup.addProperties(listOf(dorpsStraat, brink, vissteeg))

        val stations = Group()
        val stationZuid = RailRoad("STATION ZUID")
        val stationWest = RailRoad("STATION WEST")
        val stationNoord = RailRoad("STATION NOORD")
        val stationOost = RailRoad("STATION OOST")
        stations.addProperties(listOf(stationZuid, stationWest, stationNoord, stationOost))

        val arnhem = Group()
        val steenstraat = Street("STEENSTRAAT", 100,  50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val ketelStraat = Street("KETELSTRAAT", 100, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val velperPlein = Street("VELPERPLEIN", 100, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val koreMarkt = Street("KOREMARKT", 120, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        arnhem.addProperties(listOf(steenstraat, ketelStraat, velperPlein, koreMarkt))

        val utilities = Group()
        val gasfabriek = Utility("GASFABRIEK")
        val elektriciteit = Utility("ELEKTRICITEITSBEDRIJF")
        val waterleiding = Utility("WATERLEIDING")
        utilities.addProperties(listOf(elektriciteit, gasfabriek, waterleiding))

        val haarlem = Group()
        val bartelorisStraat = Street("BARTELORISSTRAAT", 140, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val zijlweg = Street("ZIJLWEG", 140, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val houtStraat = Street("HOUTSTRAAT", 140, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val spaarne = Street("SPAARNE", 160, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        haarlem.addProperties(listOf(bartelorisStraat, zijlweg, houtStraat, spaarne))

        val utrecht = Group()
        val neude = Street("NEUDE", 180, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val biltStraat = Street("BILTSTRAAT", 180, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val vreeburg = Street("VREEBURG", 200, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val domPlein = Street("DOMPLEIN", 200, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        utrecht.addProperties(listOf(neude, biltStraat, vreeburg, domPlein))

        val groningen = Group()
        val kerkhof = Street("A-KERKHOF", 220, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val groteMarkt = Street("GROTE MARKT", 220, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val hereStraat = Street("HERESTRAAT", 240, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val turfTorenStraat = Street("TURFTORENSTRAAT", 240, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        groningen.addProperties(listOf(kerkhof, groteMarkt, hereStraat, turfTorenStraat))

        val sGravenhage = Group()
        val spui = Street("SPUI", 260, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val plein = Street("PLEIN", 260, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val langePoten = Street("LANGE POTEN", 280, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val binnenHof = Street("BINNENHOF", 280, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        sGravenhage.addProperties(listOf(spui, plein, langePoten, binnenHof))

        val rotterdam = Group()
        val hofPlein = Street("HOFPLEIN", 300, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val blaak = Street("BLAAK", 300, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val coolSingel = Street("COOLSINGEL", 300, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val heemRaads = Street("HEEMRAADS", 320, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        rotterdam.addProperties(listOf(hofPlein, blaak, coolSingel, heemRaads))

        val amsterdam = Group()
        val leidseStraat = Street("LEIDSESTRAAT", 350, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val kalverStraat = Street("KALVERSTRAAT", 350, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
        val dam = Street("DAM", 400, 50, 30, StreetRentScheme(2, 10, 30, 90, 160, 250))
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

