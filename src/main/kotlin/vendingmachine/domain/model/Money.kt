package vendingmachine.domain.model

class Money(private var money: Int) {

    override fun toString(): String = money.toString()

    /**
     * 남은 금액이 상품의 가격보다 작을 때
     */
    fun lessThan(productPrize: Int): Boolean = money < productPrize
    fun spend(prize: Int) {
        overBudgetVerification(prize)
        money -= prize
    }

    operator fun minus(prize: Int) {
        money -= prize
    }

    private fun overBudgetVerification(prize: Int) {
        require(prize <= money) {
            "구매할 돈이 부족합니다."
        }
    }

    operator fun div(prize: Int): Int {
        return money / prize
    }

    fun getMoney(): Int {
        return money
    }

}