fun main() {
    val words = mutableMapOf<String, MutableList<Int>>()
    var position = 0
    while (true) {
        val word = readLine()!!
        if (word == "stop") {
            break
        }
        if (words.containsKey(word)) {
            words[word]?.add(position++)
        } else {
            words[word] = mutableListOf(position++)
        }
    }
    System.err.println(words)
    val maxFreq = words.maxByOrNull { it.value.size }
    System.err.println(maxFreq)
    print(maxFreq?.key)
}