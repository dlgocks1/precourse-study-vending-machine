package vendingmachine

import vendingmachine.controller.VendingMachineController
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

fun main() {
    try {
        val vendingMachineController = VendingMachineController(
            inputView = InputView(),
            outputView = OutputView()
        )
        vendingMachineController.slotStart()
    } catch (e: Exception) {
        println(e.message)
    }
}
