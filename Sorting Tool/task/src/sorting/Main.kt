package sorting

import java.util.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        return
    }
    if (args.contains("-sortIntegers")) {
        val numbers = readLongs()
        println("Total numbers: ${numbers.size}.")
        println("Sorted data: ${numbers.sorted().joinToString(" ")}")
        return
    }
    if (args.size < 2) {
        return
    }
    if (args[0] != "-dataType") {
        return
    }
    when (args[1]) {
        "long" -> processLongs()
        "line" -> processLines()
        "word" -> processWords()
    }
}

fun processWords() {
    val words = mutableListOf<String>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        words.add(scanner.next())
    }
    println("Total words: ${words.size}.")
    val max = words.maxByOrNull { it.length }
    val count = words.count { it == max }
    val percent = (count * 100 / words.size)
    println("The longest word: $max ($count time(s), $percent).")
}

fun processLines() {
    val lines = mutableListOf<String>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        lines.add(scanner.nextLine())
    }
    println("Total lines: ${lines.size}.")
    val max = lines.maxByOrNull { it.length }
    val count = lines.count { it == max }
    val percent = (count * 100 / lines.size)
    println("The longest line:\n$max\n($count time(s), $percent).")
}

fun processLongs() {
    val numbers = readLongs()
    println("Total numbers: ${numbers.size}.")
    val max = numbers.maxOrNull()
    val count = numbers.count { it == max }
    val percent = (count * 100 / numbers.size)
    println("The greatest number: $max ($count time(s), $percent).")
}

private fun readLongs(): List<Int> {
    val numbers = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        numbers.add(scanner.nextInt())
    }
    return numbers
}
