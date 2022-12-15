package vendingmachine.domain.model

import java.lang.IllegalArgumentException

enum class Coin(
    private val amount: Int,
) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    var count: Int = 0
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

    companion object {
        fun createCoin(amount: Int): Coin {
            values().forEach {
                if (it.amount == amount) {
                    return it
                }
            }
            throw IllegalArgumentException("코인의 단위를 지켜주세요.")
        }
    }
}