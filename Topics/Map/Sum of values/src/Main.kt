fun summator(map: Map<Int, Int>): Int {
    // put your code here
    return map.filter { it.key % 2 == 0 }.values.sum()
}