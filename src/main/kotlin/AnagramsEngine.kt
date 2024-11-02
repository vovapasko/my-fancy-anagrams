interface AnagramEngine {
    fun areAnagrams(str1: String, str2: String): Boolean
    fun anagramFromHistory(inputString: String): List<String>
}
