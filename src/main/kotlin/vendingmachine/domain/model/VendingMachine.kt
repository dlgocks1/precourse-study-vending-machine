package vendingmachine.domain.model

import vendingmachine.domain.CoinGenerator
import vendingmachine.domain.CoinMachine

class VendingMachine(private val coinGenerator: CoinGenerator) {

    private val coinMachine = CoinMachine(coinGenerator)
    lateinit var coins: Coins
        private set
    private lateinit var products: Products

    fun generateCoins(amount: Int) {
        coins = coinMachine.generateCoins(amount)
    }

    fun setProduct(productsList: String) {
        products = Products.valueOf(productsList)
    }

    fun getProductsMinPrize(): Int = products.minPrize()
    fun isSoldOut(): Boolean = products.isSoldOut()

    fun purchase(product: String): Int {
        return products.purchase(product)
    }

    fun returnChange(userMoney: Money): Coins {
        coins.returnChange(userMoney)
        return Coins()
    }

}