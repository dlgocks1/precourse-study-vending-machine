package vendingmachine.domain.model

import vendingmachine.util.COIN_UNIT_10
import vendingmachine.util.COIN_UNIT_100
import vendingmachine.util.COIN_UNIT_50
import vendingmachine.util.COIN_UNIT_500

class Coins(
    private val coins: List<Coin> = listOf(Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10)
) : List<Coin> by coins {

    fun slotCoin(coin: Int) {
        validateCoinUnit(coin)
        when (Coin.createCoin(coin)) {
            Coin.COIN_500 -> coins[0].addCount()
            Coin.COIN_100 -> coins[1].addCount()
            Coin.COIN_50 -> coins[2].addCount()
            Coin.COIN_10 -> coins[3].addCount()
        }
    }

    private fun validateCoinUnit(unit: Int) {
        require(UNIT_LIST.contains(unit)) {
            "동전의 단위가 잘못 입력됬습니다."
        }
    }


    fun returnChange(totalUserMoney: Int): List<Int> {
        val charge = mutableListOf<Int>()
        var userMoney = totalUserMoney
        coins.forEach { coin ->
            val possibleCount = coin.chargeCoin(userMoney)
            coin.minusCoin(possibleCount)
            userMoney -= (possibleCount * coin.getAmount())
            charge.add(possibleCount)
        }
        return charge.toList()
    }

    companion object {
        val UNIT_LIST = listOf(COIN_UNIT_500, COIN_UNIT_100, COIN_UNIT_50, COIN_UNIT_10)

    }

}