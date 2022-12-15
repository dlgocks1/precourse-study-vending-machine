package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.domain.model.Money
import java.lang.IllegalArgumentException

class InputView {

    fun vendingMachineAmount(): Int {
        println("자판기가 보유하고 있는 금액을 입력해 주세요.")
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")
    }

    fun vendingMachinProduct(): String {
        println("\n상품명과 가격, 수량을 입력해 주세요.")
        return Console.readLine()
    }

    fun purchaseProduct(money: Money): String {
        println("\n투입 금액: ${money}원")
        println("구매할 상품명을 입력해 주세요.")
        return Console.readLine()
    }

    fun userAmount(): Int {
        println("\n투입 금액을 입력해 주세요.")
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("금액은 숫자로 입력해야 합니다.")
    }
}