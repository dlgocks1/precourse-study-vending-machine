package vendingmachine.domain.model

import vendingmachine.util.ZERO

data class Product(
    val name: String,
    val prize: Int,
    var count: Int,
) {
    fun isSoldOut(): Boolean {
        return count == ZERO
    }

    fun purchase(): Int {
        count -= 1
        return prize
    }
}