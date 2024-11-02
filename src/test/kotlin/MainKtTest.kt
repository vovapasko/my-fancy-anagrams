import org.example.InMemoryAnagramEngine
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class InMemoryAnagramEngineTest {
    val inMemoryAnagramEngine = InMemoryAnagramEngine()

    @AfterEach
    fun tearDown() {
        inMemoryAnagramEngine.history.clear()
    }

    @Test
    fun testWordsAreAnagrams() {
        assertTrue(inMemoryAnagramEngine.areAnagrams("abc", "cba"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("abc"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("cba"))
    }

    @Test
    fun testWordsAreNotAnagrams() {
        assertFalse(inMemoryAnagramEngine.areAnagrams("abc", "def"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("abc"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("def"))
    }

    @Test
    fun testTextsAreAnagrams() {
        assertTrue(inMemoryAnagramEngine.areAnagrams("New York Times", "monkeys write"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("New York Times"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("monkeys write"))
        assertTrue(inMemoryAnagramEngine.areAnagrams("Church of Scientology", "rich-chosen goofy cult"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("Church of Scientology"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("rich-chosen goofy cult"))
        assertTrue(inMemoryAnagramEngine.areAnagrams("William Shakespeare", "I am a weakish speller"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("William Shakespeare"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("I am a weakish speller"))
        assertTrue(inMemoryAnagramEngine.areAnagrams("William Shakespeare", "I'll make a wise phrase"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("William Shakespeare"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("I'll make a wise phrase"))
    }


    @Test
    fun testTextsAreNotAnagrams() {
        assertFalse(inMemoryAnagramEngine.areAnagrams("I am not an anagram", "not anagram"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("I am not an anagram"))
        assertTrue(inMemoryAnagramEngine.history.containsKey("not anagram"))
    }


    @Nested
    inner class TestAnagramsFromHistory {

        val inMemoryAnagramEngine = InMemoryAnagramEngine()


        @Test
        fun testAnagramsInHistory() {
            val str1 = "New York Times"
            val str2 = "Madam Curie"
            val str3 = "George Bush"
            val str4 = "I am a weakish speller"
            val str5 = "William Shakespeare"
            val str6 = "williaMshakespEare"

            val history = mutableMapOf(
                str1 to str1.transformToMap(),
                str2 to str2.transformToMap(),
                str3 to str3.transformToMap(),
                str4 to str4.transformToMap(),
                str5 to str5.transformToMap(),
                str6 to str6.transformToMap()
            )

            val input = "I'll make a wise phrase"
            val output = listOf(str4, str5, str6)


            inMemoryAnagramEngine.history.putAll(history)
            assertEquals(output, inMemoryAnagramEngine.anagramFromHistory(history, input))
        }
    }

}