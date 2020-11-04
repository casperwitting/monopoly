package player

import org.junit.Assert.assertEquals
import org.junit.Test
import payment.Bill

internal class PlayerTest {
    @Test
    fun testCreatePlayer() {
        val player = Player()
        val exampleName = "Leonard"
        player.name = exampleName

        assertEquals(exampleName, player.name)
    }

    @Test
    fun testAddGetBills() {
        val player = Player()
        val bill = Bill(200)

        player.bills.add(bill)

        assertEquals(bill, player.bills.first())
    }

    @Test
    fun testGetTotalCash() {
        val player = Player()

        player.bills.add(Bill(200))
        player.bills.add(Bill(200))
        player.bills.add(Bill(100))

        assertEquals(500, player.getTotalCash())
    }

    @Test
    fun testSetGetToken() {
        val player = Player()

        val token = Token("Racewagen")
        player.token = token

        assertEquals(token, player.token)
    }
}