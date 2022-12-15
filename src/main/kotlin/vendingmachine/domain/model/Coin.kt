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

    fun addCount() {
        count += 1
    }

    fun getAmount() = amount

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