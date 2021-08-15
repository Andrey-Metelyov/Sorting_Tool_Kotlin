fun bill(priceList: Map<String, Int>, shoppingList: Array<String>): Int {
    var total = 0
    for (good in shoppingList) {
        total += priceList[good] ?: 0
    }
    return total
}
