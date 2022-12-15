package vendingmachine.domain.model

class Money(private var money: Int) {

    override fun toString(): String = money.toString()

    /**
     * 남은 금액이 상품의 가격보다 작을 때
     */
    fun lessThan(productPrize: Int): Boolean = money < productPrize

}