package cli

import AnagramEngine
import kotlin.system.exitProcess

class RuntimeCLI(private val engine: AnagramEngine) : CLI {

    override fun start() {
        while (true) {
            println("Enter the command: (a for anagrams, h for history). Press everything else to exit.")
            val command = readln()

            when (command) {
                "a" -> anagrams()
                "h" -> history()
                else -> exitProcess(0)
            }
        }
    }

    private fun history() {
        println("Enter the text: ")
        val input = readln()
        println("The previous anagrams are: ")
        val previousAnagrams = engine.anagramFromHistory(input)
        when (previousAnagrams.size) {
            0 -> println("No anagrams found")
            else -> previousAnagrams.forEach { println(it) }
        }
    }

    private fun anagrams() {
        println("Enter the first text: ")
        val anagram1 = readln()
        println("Enter the second text: ")
        val anagram2 = readln()

        when (engine.areAnagrams(anagram1, anagram2)) {
            true -> println("$anagram1 and $anagram2 are anagrams")
            false -> println("$anagram1 and $anagram2 are not anagrams")
        }
    }
}
