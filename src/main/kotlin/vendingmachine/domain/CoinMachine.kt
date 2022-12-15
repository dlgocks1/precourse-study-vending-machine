package vendingmachine.domain

import vendingmachine.domain.model.Coins
import vendingmachine.util.ERR_MONEY_UNIT

class CoinMachine(private val coinGenerator: CoinGenerator) {

    fun generateCoins(totalAmount: Int): Coins {
        validateAmount(totalAmount)
        val coins = Coins()
        var amount = totalAmount
        while (amount != 0) {
            val coin = coinGenerator.generateRandomCoin(amount)
            amount -= coin
            coins.slotCoin(coin)
        }
        return coins
    }

    private fun validateAmount(amount: Int) {
        require(amount % 10 == 0) {
            ERR_MONEY_UNIT
        }
    }

}