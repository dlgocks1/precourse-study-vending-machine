package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.domain.model.Money
import vendingmachine.util.*
import java.lang.IllegalArgumentException

class InputView {

    fun vendingMachineAmount(): Int {
        println(ViewMessage.INPUT_MACHIN_AMOUNT)
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")
    }

    fun vendingMachinProduct(): String {
        println(ViewMessage.INPUT_MACHIN_PRODUCT)
        return Console.readLine()
    }

    fun purchaseProduct(money: Money): String {
        println(ViewMessage.INPUT_PURCHASE_MONEY_STATUS.format(money))
        println(ViewMessage.INPUT_PURCHASE_NAME)
        return Console.readLine()
    }

    fun userAmount(): Int {
        println(ViewMessage.INPUT_PURCHASE_MONEY)
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")
    }
}