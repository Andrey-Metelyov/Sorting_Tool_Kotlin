package sorting

import java.util.*

fun main(args: Array<String>) {
    if (args.size < 2) {
        return
    }
    if (args[0] != "-dataType") {
        return
    }
    when (args[1]) {
        "long" -> readLongs()
        "line" -> readLines()
        "word" -> readWords()
    }
}

fun readWords() {
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

fun readLines() {
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

fun readLongs() {
    val numbers = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        numbers.add(scanner.nextInt())
    }
    println("Total numbers: ${numbers.size}.")
    val max = numbers.maxOrNull()
    val count = numbers.count { it == max }
    val percent = (count * 100 / numbers.size)
    println("The greatest number: $max ($count time(s), $percent).")
}
