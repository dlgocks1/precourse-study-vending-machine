package vendingmachine.view

import vendingmachine.domain.model.Coins
import vendingmachine.domain.model.Coins.Companion.UNIT_LIST
import vendingmachine.util.INPUT_PURCHASE_MONEY_STATUS
import vendingmachine.util.OUTPUT_CHARGE
import vendingmachine.util.OUTPUT_MACHIN_COIN
import vendingmachine.util.OUTPUT_MACHIN_COIN_RESULT

class OutputView {

    /**
     * 자판기가 보유한 동전을 출력한다.
     */
    fun vendingMachinCoin(coins: Coins) {
        println(OUTPUT_MACHIN_COIN)
        coins.forEach {
            println(OUTPUT_MACHIN_COIN_RESULT.format(it.getAmount(), it.count))
        }
    }

    /**
     * 잔돈을 출력한다.
     */
    fun returnChange(userMoney: Int, returnChange: List<Int>) {
        println(INPUT_PURCHASE_MONEY_STATUS.format(userMoney.toString()))
        println(OUTPUT_CHARGE)
        println(userMoney)
        println(returnChange.toString())
        UNIT_LIST.forEachIndexed { idx, unit ->
            if (returnChange[idx] == 0) return@forEachIndexed
            println(OUTPUT_MACHIN_COIN_RESULT.format(unit, returnChange[idx]))
        }
    }
}