package vendingmachine.view

import vendingmachine.domain.model.Coins
import java.lang.StringBuilder

class OutputView {

    /**
     * 자판기가 보유한 동전을 출력한다.
     */
    fun vendingMachinCoin(coins: Coins) {
        println("\n자판기가 보유한 동전")
        coins.forEach {
            println("${it.getAmount()}원 - ${it.count}개")
        }
    }

    /**
     * 잔돈을 출력한다.
     */
    fun result() {
        println("투입 금액: 0")
        println("잔돈")
        // 잔돈 출력
    }
}