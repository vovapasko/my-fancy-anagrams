import org.example.areAnagrams
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun testWordsAreAnagrams() {
        assertTrue(areAnagrams("abc", "cba"))
        assertFalse(areAnagrams("abc", "def"))
    }

    @Test
    fun testTextsAreAnagrams() {
        assertTrue(areAnagrams("New York Times", "monkeys write"))
        assertTrue(areAnagrams("Church of Scientology", "rich-chosen goofy cult"))
    }

}