import kotlinx.cli.*
import kotlin.system.exitProcess


fun main() {
    val engine = InMemoryAnagramEngine()
    while (true) {
        println("Enter the command: (a for anagrams, h for history). Press everything else to exit.")
        val command = readln()

        when (command) {
            "a" -> anagrams(engine)
            "h" -> history(engine)
            else -> exitProcess(0)
        }
    }
}

fun history(engine: AnagramEngine) {
    println("Enter the text: ")
    val input = readln()
    println("The previous anagrams are: ")
    val previousAnagrams = engine.anagramFromHistory(input)
    when (previousAnagrams.size) {
        0 -> println("No anagrams found")
        else -> previousAnagrams.forEach { println(it) }
    }
}

fun anagrams(engine: AnagramEngine) {
    println("Enter the first text: ")
    val anagram1 = readln()
    println("Enter the second text: ")
    val anagram2 = readln()

    when (engine.areAnagrams(anagram1, anagram2)) {
        true -> println("$anagram1 and $anagram2 are anagrams")
        false -> println("$anagram1 and $anagram2 are not anagrams")
    }
}