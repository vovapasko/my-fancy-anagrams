interface AnagramEngine {
    fun areAnagrams(str1: String, str2: String): Boolean
    fun anagramFromHistory(history: Map<String, Map<Char, Int>>, inputString: String): List<String>
}
