package vendingmachine.domain.model

import vendingmachine.util.ErrorMessage

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

    private fun overBudgetVerification(prize: Int) {
        require(prize <= money) {
            ErrorMessage.ERR_NO_MONEY
        }
    }

    fun getMoney(): Int {
        return money
    }

}