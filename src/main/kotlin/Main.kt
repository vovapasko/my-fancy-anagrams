import kotlinx.cli.*


fun main(args: Array<String>) {
    val parser = ArgParser("example")
    val inMemoryAnagramEngine = InMemoryAnagramEngine()
    println("History is ${inMemoryAnagramEngine.history}")
    val anagramsCommand = AnagramsCommand(inMemoryAnagramEngine)
    val historyCommand = HistoryCommand(inMemoryAnagramEngine)
    parser.subcommands(anagramsCommand, historyCommand)
    parser.parse(args)
}

@OptIn(ExperimentalCli::class)
class AnagramsCommand(private val engine: AnagramEngine) :
    Subcommand("anagrams", "Prints if two input texts are anagrams or not") {
    val anagrams by argument(
        ArgType.String,
        fullName = "anagrams",
        description = "Prints if two input texts are anagrams or not"
    ).multiple(2)


    override fun execute() {
        if (anagrams.size != 2) {
            throw IllegalArgumentException("Two input texts are required")
        }
        when (engine.areAnagrams(anagrams[0], anagrams[1])) {
            true -> println("${anagrams[0]} and ${anagrams[1]} are anagrams")
            false -> println("${anagrams[0]} and ${anagrams[1]} are NOT anagrams")
        }
    }
}

@OptIn(ExperimentalCli::class)
class HistoryCommand(private val engine: AnagramEngine) :
    Subcommand("history", "Prints all anagrams from input history") {
    val history by argument(
        ArgType.String,
        fullName = "history",
        description = "Prints all anagrams from input history"
    )

    override fun execute() {
        engine.anagramFromHistory(history).forEach { println(it) }
    }
}




