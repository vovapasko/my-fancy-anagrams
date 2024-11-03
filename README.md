## My Fancy Anagrams

Welcome! You can run this program in two ways: via the CLI or via the Gradle build from your IDE.

Requirements:

- Java 22 or
- Gradle 8.8 or higher and Kotlin v.1.9.22 or higher if you want to run via IDE and Gradle

### Run via IDE

Just open your IDE and run `./gradlew shadowJar` to build the jar file and
`java -jar build/libs/my-fancy-anagrams-1.0-SNAPSHOT-all.jar` to run the program.

Alternatively you can start the program from the Main.kt file directly.

### Download the CLI

You can find the jar file in release tab on
the [GitHub repository](https://github.com/vovapasko/my-fancy-anagrams/releases/download/v1.0/my-fancy-anagrams-1.0-SNAPSHOT-all.jar)
and download it.

To run it, make it executable with `chmod +x` command and run with `java -jar ./my-fancy-anagrams-1.0-SNAPSHOT-all.jar`
command

### How to use it?

There are two features in this release:

#### Feature 1. Anagrams checker

Checks if two texts are anagrams of each other by the definition described in the english wikipedia page for
anagram.

In this CLI version you run it by entering `a` command and then provide two strings that you want to check.

#### Feature 2. Anagrams history

This feature takes a given input string and returns a list of all previously
entered texts that are anagrams of it.
This applies to all past inputs from feature #1 within a single run of the
program. In this release I do not persist data across multiple executions.

In this CLI version you run it by entering `h` command and then provide the string.

You can exit the program by entering something else except `a` or `h` on the welcome line. 

Have fun! 



