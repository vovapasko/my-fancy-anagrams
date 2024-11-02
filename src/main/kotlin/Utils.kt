fun String.transformToMap(): Map<Char, Int> {
    return this.lowercase().filter { it.isLetter() }.groupBy { it }.mapValues { it.value.size }
}