package vendingmachine.view

import vendingmachine.domain.model.Coins
import vendingmachine.domain.model.Coins.Companion.UNIT_LIST

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
    fun returnChange(userMoney: Int, returnChange: List<Int>) {
        println("투입 금액: $userMoney")
        println("잔돈")
        println(userMoney)
        println(returnChange.toString())
        UNIT_LIST.forEachIndexed { idx, unit ->
            if (returnChange[idx] == 0) return@forEachIndexed
            println("${unit}원 - ${returnChange[idx]}개")
        }
    }
}