package gameplay

import junit.framework.TestCase
import org.junit.Test

class DiceTest {
    @Test
    fun testRollDice() {
        val dice = Dice()

        val roll: Int = dice.roll()

        TestCase.assertTrue(roll in 1..6)
    }
}