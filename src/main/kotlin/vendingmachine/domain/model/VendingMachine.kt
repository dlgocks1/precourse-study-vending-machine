package vendingmachine.domain.model

import vendingmachine.domain.CoinGenerator
import vendingmachine.domain.CoinMachine

class VendingMachine(private val coinGenerator: CoinGenerator) {

    private val coinMachine = CoinMachine(coinGenerator)
    lateinit var coins: Coins
        private set
    lateinit var products: Products
        private set

    fun generateCoins(amount: Int) {
        coins = coinMachine.generateCoins(amount)
    }

    fun setProduct(productsList: String) {
        products = Products.valueOf(productsList)
    }

}