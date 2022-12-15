package vendingmachine.domain.model

data class Product(
    val name: String,
    val prize: Int,
    val count: Int,
)