package vendingmachine.domain.model

import vendingmachine.util.*
import java.lang.IllegalArgumentException

enum class Coin(
    private val amount: Int,
) {
    COIN_500(COIN_UNIT_500),
    COIN_100(COIN_UNIT_100),
    COIN_50(COIN_UNIT_50),
    COIN_10(COIN_UNIT_10);

    var count: Int = ZERO
        private set

    fun addCount(num: Int = 1) {
        count += num
    }

    fun getAmount() = amount

    fun chargeCoin(prize: Int): Int {
        if (count >= prize / amount) {
            return prize / amount
        }
        return count
    }

    fun minusCoin(num: Int) {
        count -= num
    }

    companion object {
        fun createCoin(amount: Int): Coin {
            values().forEach {
                if (it.amount == amount) {
                    return it
                }
            }
            throw IllegalArgumentException(ErrorMessage.ERR_COIN_UNIT)
        }
    }
}