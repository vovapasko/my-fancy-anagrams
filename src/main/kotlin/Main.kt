import cli.RuntimeCLI


fun main() {
    val engine = InMemoryAnagramEngine()
    val cli = RuntimeCLI(engine)
    cli.start()
}
