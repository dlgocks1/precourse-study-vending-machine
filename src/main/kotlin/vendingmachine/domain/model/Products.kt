package vendingmachine.domain.model

class Products(private val products: List<Product>) : List<Product> by products {

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