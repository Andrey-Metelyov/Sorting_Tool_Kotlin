package sorting

import java.util.*

fun main() {
    val numbers = mutableListOf<Int>()
    val scanner = Scanner(System.`in`)

    while (scanner.hasNext()) {
        numbers.add(scanner.nextInt())
    }
    println("Total numbers: ${numbers.size}.")
    val max = numbers.maxOrNull()
    val count = numbers.count { it == max }
    println("The greatest number: $max ($count time(s)).")
}
