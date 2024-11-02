class InMemoryAnagramEngine : AnagramEngine {
    val history = mutableMapOf<String, Map<Char, Int>>()

    override fun areAnagrams(str1: String, str2: String): Boolean {
        history[str1] = str1.transformToMap()
        history[str2] = str2.transformToMap()
        return str1.transformToMap() ==
                str2.transformToMap()
    }

    // Returns all string anagrams from input history
    override fun anagramFromHistory(inputString: String): List<String> {
        val anagrams = history.filterValues { value -> value == inputString.transformToMap() }
        return anagrams.keys.toList()
    }

}