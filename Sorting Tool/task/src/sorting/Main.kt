package sorting

import java.io.File
import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        return
    }
    val parameters = getParameters(args)
    if (parameters.containsKey("-sortingType") && parameters["-sortingType"] == null) {
        println("No sorting type defined!")
        return
    }
    val sortingType = parameters["-sortingType"] ?: "natural"
    if (parameters.containsKey("-dataType") && parameters["-dataType"] == null) {
        println("No data type defined!")
        return
    }
    val dataType = parameters["-dataType"] ?: "word"
    val inputFile = parameters["-inputFile"]
    val outputFile = parameters["-outputFile"]

    when (dataType) {
        "word" -> {
            val collection = readWords(inputFile)
            processWords(collection, sortingType, outputFile)
        }
        "long" -> {
            val collection = readLongs(inputFile)
            processLongs(collection, sortingType, outputFile)
        }
        "line" -> {
            val collection = readLines(inputFile)
            processLines(collection, sortingType, outputFile)
        }
    }
}

fun getParameters(args: Array<String>): Map<String, String?> {
    System.err.println(args.joinToString())
    val result = mutableMapOf<String, String?>()
    var index = 0
    while (index < args.size) {
        when (val name = args[index++]) {
            "-sortingType", "-dataType", "-inputFile", "-outputFile" -> {
                val value = if (index < args.size) args[index++] else null
                result[name] = value
                System.err.println("$name = $value")
            }
            else -> {
                println("\"$name\" is not a valid parameter. It will be skipped.")
            }
        }

    }
    return result
}

fun processWords(collection: List<String>, sortingType: String, outputFile: String?) {
    outputResult("Total words: ${collection.size}.", outputFile)
    if (sortingType == "natural") {
        outputResult("Sorted data: ${collection.sorted().joinToString(" ")}", outputFile)
    } else {
        val sorted = collection.map { it to collection.count { value -> value == it } }
            .toSet()
            .sortedWith(compareBy({ it.second }, { it.first }))
        val total = collection.size
        sorted.forEach { (key, value) ->
            outputResult("$key: $value time(s), ${value * 100 / total}%", outputFile)
        }
    }
}

fun outputResult(line: String, outputFile: String?) {
    System.err.println("($outputFile) $line")
    if (outputFile == null) {
        println(line)
    } else {
        System.err.println("use $outputFile as output")
        File(outputFile).appendText(line.plus(System.lineSeparator()))
    }
}

private fun readWords(inputFile: String?): List<String> {
    val words = mutableListOf<String>()
    val scanner = if (inputFile != null) Scanner(File(inputFile)) else Scanner(System.`in`)

    while (scanner.hasNext()) {
        words.add(scanner.next())
    }
    scanner.close()
    return words
}

fun processLines(collection: List<String>, sortingType: String, outputFile: String?) {
    outputResult("Total lines: ${collection.size}.", outputFile)
    if (sortingType == "natural") {
        outputResult("Sorted data:\n${collection.sorted().joinToString("\n")}", outputFile)
    } else {
        val sorted = collection.map { it to collection.count { value -> value == it } }
            .toSet()
            .sortedWith(compareBy({ it.second }, { it.first }))
        val total = collection.size
        sorted.forEach { (key, value) ->
            outputResult("$key: $value time(s), ${value * 100 / total}%", outputFile)
        }
    }
}

private fun readLines(inputFile: String?): List<String> {
    val lines = mutableListOf<String>()
    val scanner = if (inputFile != null) Scanner(File(inputFile)) else Scanner(System.`in`)

    while (scanner.hasNext()) {
        lines.add(scanner.nextLine())
    }
    scanner.close()
    return lines
}

fun processLongs(collection: List<Long>, sortingType: String, outputFile: String?) {
    outputResult("Total numbers: ${collection.size}.", outputFile)
    if (sortingType == "natural") {
        outputResult("Sorted data: ${collection.sorted().joinToString(" ")}", outputFile)
    } else {
        val sorted = collection.map { it to collection.count { value -> value == it } }
            .toSet()
            .sortedWith(compareBy({ it.second }, { it.first }))
        val total = collection.size
        sorted.forEach { (key, value) ->
            outputResult("$key: $value time(s), ${value * 100 / total}%", outputFile)
        }
    }
}

private fun readLongs(inputFile: String?): List<Long> {
    val numbers = mutableListOf<Long>()
    val scanner = if (inputFile != null) Scanner(File(inputFile)) else Scanner(System.`in`)

    while (scanner.hasNext()) {
        val number = scanner.next()
        try {
            numbers.add(number.toLong())
        } catch (e: NumberFormatException) {
            println("$number is not a long. It will be skipped.")
        }
    }
    scanner.close()
    return numbers
}
