package board

import junit.framework.TestCase.*
import org.junit.Ignore
import org.junit.Test

class BoardFactoryTest {
    @Test
    @Ignore
    fun testWhenBuildingBoardThenBoardHasCorrectAmountOfSpaces() {
        val builder = BoardFactory()
        val board : Board = builder.makeBoard()

        assertEquals(13, board.spaces.count())
    }
}