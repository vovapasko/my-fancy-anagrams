package org.example

fun main() {
    val textOne = "Hello"
    val textTwo = "World"

    val areAnagrams = areAnagrams(textOne, textTwo)
    println(areAnagrams)

}

fun areAnagrams(str1: String, str2: String): Boolean {
    return str1.transformToMap() ==
            str2.transformToMap()
}

fun String.transformToMap(): Map<Char, Int> {
    return this.lowercase().filter { it.isLetter() }.groupBy { it }.mapValues { it.value.size }
}


// Returns all string anagrams from input history
fun anagramFromHistory(history: Map<String, Map<Char, Int>>, inputString: String): List<String> {
    val anagrams = history.filterValues { value -> value == inputString.transformToMap() }
    return anagrams.keys.toList()
}


