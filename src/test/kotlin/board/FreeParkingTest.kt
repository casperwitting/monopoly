package board

import space.FreeParking
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test

class FreeParkingTest {
    private lateinit var freeParking : FreeParking
    @Before
    fun setUp() {
        freeParking = FreeParking("station zuid")
    }

    @Test
    fun testUtilityPriceIsZero() {
        TestCase.assertEquals(0, freeParking.price)
    }
}