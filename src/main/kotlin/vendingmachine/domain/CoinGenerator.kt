package vendingmachine.domain

interface CoinGenerator {
    fun generateRandomCoin(amount: Int): Int
}