package vendingmachine.domain.model

class Coins {

    private var coins: List<Coin> = listOf(Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10)

    fun slotCoin(coin: Int) {
        require(validateCoinUnit(coin)) {
            "동전의 단위가 잘 못 입력됬습니다."
        }
        when (Coin.createCoin(coin)) {
            Coin.COIN_500 -> coins[0].addCount()
            Coin.COIN_100 -> coins[1].addCount()
            Coin.COIN_50 -> coins[2].addCount()
            Coin.COIN_10 -> coins[3].addCount()
        }
    }

    private fun validateCoinUnit(unit: Int) = unitList.contains(unit)

    /**
     * 코인리스트를 반환한다.
     * 코인 리스트는 500, 100, 50, 10 내림차순으로 반환된다.
     */
    fun count(): List<Int> = coins.map {
        it.count
    }

    companion object {
        val unitList = listOf(500, 100, 50, 10)

    }

}