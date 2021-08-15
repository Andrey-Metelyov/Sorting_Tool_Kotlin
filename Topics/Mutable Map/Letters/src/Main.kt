fun main() {
    val letters = mutableMapOf<Int, String>()
    var counter = 0
    do {
        val line = readLine()!!
        letters[counter++] = line
    } while (line != "z")
    print(letters[3])
}