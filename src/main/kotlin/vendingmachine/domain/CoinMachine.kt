package vendingmachine.domain

import vendingmachine.domain.model.Coins
import vendingmachine.util.ErrorMessage
import vendingmachine.util.MINIMUN_UNIT
import vendingmachine.util.ZERO

class CoinMachine(private val coinGenerator: CoinGenerator) {

    fun generateCoins(totalAmount: Int): Coins {
        validateAmount(totalAmount)
        val coins = Coins()
        var amount = totalAmount
        while (amount != ZERO) {
            val coin = coinGenerator.generateRandomCoin(amount)
            amount -= coin
            coins.slotCoin(coin)
        }
        return coins
    }

    private fun validateAmount(amount: Int) {
        require(amount % MINIMUN_UNIT == ZERO) {
            ErrorMessage.ERR_MONEY_UNIT
        }
    }

}