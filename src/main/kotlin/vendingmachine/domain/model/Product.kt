package vendingmachine.domain.model

data class Product(
    val name: String,
    val prize: Int,
    var count: Int,
) {
    fun isSoldOut(): Boolean {
        return count == 0
    }

    fun purchase() {
        count -= 1
    }
}