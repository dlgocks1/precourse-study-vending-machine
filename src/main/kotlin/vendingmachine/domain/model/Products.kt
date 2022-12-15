package vendingmachine.domain.model

class Products(private val products: List<Product>) : List<Product> by products {
    fun minPrize(): Int = products.minOf { it.prize }
    fun isSoldOut(): Boolean = products.all { it.count == 0 }
    fun purchase(product: String) {
        checkValidProduct(product)
        products.find { it.name == product }?.purchase()
    }

    private fun checkValidProduct(product: String) {
        val isSoldOut = products.find { it.name == product }?.isSoldOut()
            ?: throw IllegalArgumentException("구매할 상품이 존재하지 않습니다.")
        require(!isSoldOut) {
            "구매할 상품이 매진 상태입니다."
        }
    }

    companion object {
        fun valueOf(products: String): Products {
            return Products(
                products.split(";").map { product ->
                    parsingProduct(product)
                }
            )
        }

        private fun parsingProduct(product: String): Product {
            val parsingResult = product.replace("[", "")
                .replace("]", "")
                .split(",")
            return Product(
                name = parsingResult[0],
                prize = parsingResult[1].toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자여야 합니다."),
                count = parsingResult[2].toIntOrNull() ?: throw IllegalArgumentException("수량은 숫자여야 합니다.")
            )
        }
    }

}