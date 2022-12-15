package vendingmachine.domain.model

import vendingmachine.util.ERR_NO_PRODUCT
import vendingmachine.util.ERR_SOLD_OUT

class Products(private val products: List<Product>) : List<Product> by products {
    fun minPrize(): Int = products.minOf { it.prize }
    fun isSoldOut(): Boolean = products.all { it.count == 0 }
    fun purchase(product: String): Int {
        checkValidProduct(product)
        return products.find { it.name == product }!!.purchase() // 해당 상품이 존재하는지는 이미 체크했음
    }

    private fun checkValidProduct(product: String) {
        val isSoldOut = products.find { it.name == product }?.isSoldOut()
            ?: throw IllegalArgumentException(ERR_NO_PRODUCT)
        require(!isSoldOut) {
            ERR_SOLD_OUT
        }
    }

    companion object {

        private const val SEMI_COLON = ";"
        private const val LEFT_BRACKET = "["
        private const val RIGHT_BRACKET = "]"
        private const val COLON = ","
        private const val BLANK = ""
        fun valueOf(products: String): Products {
            return Products(
                products.split(SEMI_COLON).map { product ->
                    parsingProduct(product)
                }
            )
        }

        private fun parsingProduct(product: String): Product {
            val parsingResult = product.replace(LEFT_BRACKET, BLANK)
                .replace(RIGHT_BRACKET, BLANK)
                .split(COLON)
            return Product(
                name = parsingResult[0],
                prize = parsingResult[1].toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자여야 합니다."),
                count = parsingResult[2].toIntOrNull() ?: throw IllegalArgumentException("수량은 숫자여야 합니다.")
            )
        }
    }

}