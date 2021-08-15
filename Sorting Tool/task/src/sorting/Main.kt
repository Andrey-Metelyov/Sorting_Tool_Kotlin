package sorting

import java.util.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        return
    }
    val parameters = getParameters(args)
    val sortingType = parameters["-sortingType"] ?: "natural"
    val dataType = parameters["-dataType"]

    when (dataType) {
        "word" -> {
            val collection = readWords()
            println("Total words: ${collection.size}.")
            if (sortingType == "natural") {
                println("Sorted data: ${collection.sorted().joinToString(" ")}")
            } else {
                val sorted = collection.map { it to collection.count { value -> value == it } }
                    .toSet()
                    .sortedWith(compareBy({ it.second }, { it.first }))
                val total = collection.size
                sorted.forEach { (key, value) ->
                    println("$key: $value time(s), ${value * 100 / total}%")
                }
            }
        }
        "long" -> {
            val collection = readLongs()
            println("Total numbers: ${collection.size}.")
            if (sortingType == "natural") {
                println("Sorted data: ${collection.sorted().joinToString(" ")}")
            } else {
                val sorted = collection.map { it to collection.count { value -> value == it } }
                    .toSet()
                    .sortedWith(compareBy({ it.second }, { it.first }))
                val total = collection.size
                sorted.forEach { (key, value) ->
                    println("$key: $value time(s), ${value * 100 / total}%")
                }
            }
        }
        "line" -> {
            val collection = readLines()
            println("Total lines: ${collection.size}.")
            if (sortingType == "natural") {
                println("Sorted data:\n${collection.sorted().joinToString("\n")}")
            } else {
                val sorted = collection.map { it to collection.count { value -> value == it } }
                    .toSet()
                    .sortedWith(compareBy({ it.second }, { it.first }))
                val total = collection.size
                sorted.forEach { (key, value) ->
                    println("$key: $value time(s), ${value * 100 / total}%")
                }
            }
        }
    }
}

fun getParameters(args: Array<String>): Map<String, String> {
    System.err.println(args.joinToString())
    val result = mutableMapOf<String, String>()
    var index = 0
    while (index < args.size) {
        result[args[index++]] = args[index++]
    }
    return result
}

fun processWords() {
    val words = readWords()
    println("Total words: ${words.size}.")
    val max = words.maxByOrNull { it.length }
    val count = words.count { it == max }
    val percent = (count * 100 / words.size)
    println("The longest word: $max ($count time(s), $percent).")
}

private fun readWords(): List<String> {
    val words = mutableListOf<String>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        words.add(scanner.next())
    }
    return words
}

fun processLines() {
    val lines = readLines()
    println("Total lines: ${lines.size}.")
    val max = lines.maxByOrNull { it.length }
    val count = lines.count { it == max }
    val percent = (count * 100 / lines.size)
    println("The longest line:\n$max\n($count time(s), $percent).")
}

private fun readLines(): List<String> {
    val lines = mutableListOf<String>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        lines.add(scanner.nextLine())
    }
    return lines
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
