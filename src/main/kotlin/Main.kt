package org.example

fun main() {
    val textOne = "Hello"
    val textTwo = "World"

    val areAnagrams = areAnagrams(textOne, textTwo)
    println(areAnagrams)

}

fun areAnagrams(str1: String, str2: String): Boolean {
    return str1.lowercase().filter { it.isLetter() }.groupBy { it }.mapValues { it.value.size } ==
            str2.lowercase().filter { it.isLetter() }.groupBy { it }.mapValues { it.value.size }
}

