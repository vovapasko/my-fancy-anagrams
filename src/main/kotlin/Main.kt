import kotlinx.cli.*


fun main(args: Array<String>) {
    val parser = ArgParser("example")
    val anagrams by parser.option(ArgType.String, description = "Prints if two input texts are anagrams or not").multiple()
    parser.parse(args)
    if (anagrams.size != 2) {
        throw IllegalArgumentException("Two input texts are required")
    }
    val engine = InMemoryAnagramEngine()
    when (engine.areAnagrams(anagrams[0], anagrams[1])) {
        true -> println("${anagrams[0]} and ${anagrams[1]} are anagrams")
        false -> println("${anagrams[0]} and ${anagrams[1]} are NOT anagrams")
    }
}





