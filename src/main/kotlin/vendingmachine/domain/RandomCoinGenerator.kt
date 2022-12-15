package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.util.COIN_UNIT_10
import vendingmachine.util.COIN_UNIT_100
import vendingmachine.util.COIN_UNIT_50
import vendingmachine.util.COIN_UNIT_500

class RandomCoinGenerator : CoinGenerator {
    override fun generateRandomCoin(amount: Int): Int =
        if (amount >= COIN_UNIT_500) {
            Randoms.pickNumberInList(listOf(COIN_UNIT_500, COIN_UNIT_100, COIN_UNIT_50, COIN_UNIT_10))
        } else if (amount >= COIN_UNIT_100) {
            Randoms.pickNumberInList(listOf(COIN_UNIT_100, COIN_UNIT_50, COIN_UNIT_10))
        } else if (amount >= COIN_UNIT_50) {
            Randoms.pickNumberInList(listOf(COIN_UNIT_50, COIN_UNIT_10))
        } else {
            COIN_UNIT_10
        }
}