import org.example.anagramFromHistory
import org.example.areAnagrams
import org.example.transformToMap
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
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
        assertTrue(areAnagrams("William Shakespeare", "I am a weakish speller"))
        assertTrue(areAnagrams("William Shakespeare", "I'll make a wise phrase"))
    }


    @Nested
    inner class TestAnagramsFromHistory {
        @Test
        fun testAnagramsInHistory() {
            val str1 = "New York Times"
            val str2 = "Madam Curie"
            val str3 = "George Bush"
            val str4 = "I am a weakish speller"
            val str5 = "William Shakespeare"
            val str6 = "williaMshakespEare"

            val history = mapOf(
                str1 to str1.transformToMap(),
                str2 to str2.transformToMap(),
                str3 to str3.transformToMap(),
                str4 to str4.transformToMap(),
                str5 to str5.transformToMap(),
                str6 to str6.transformToMap()
            )

            val input = "I'll make a wise phrase"
            val output = listOf(str4, str5, str6)

            assertEquals(output, anagramFromHistory(history, input))
        }
    }

}