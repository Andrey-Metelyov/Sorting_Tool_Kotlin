fun main() {
    val letter = readLine()!!.lowercase().first()
    val vowels = mapOf(
        'a' to 'a' - 'a' + 1,
        'e' to 'e' - 'a' + 1,
        'i' to 'i' - 'a' + 1,
        'o' to 'o' - 'a' + 1,
        'u' to 'u' - 'a' + 1,
    )
    // write your code here
    println(vowels.getOrDefault(letter, 0))
}