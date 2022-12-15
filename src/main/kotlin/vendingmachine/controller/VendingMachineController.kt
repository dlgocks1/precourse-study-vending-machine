package vendingmachine.controller

import vendingmachine.domain.RandomCoinGenerator
import vendingmachine.domain.model.VendingMachine
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

class VendingMachineController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val vendingMachine = VendingMachine(RandomCoinGenerator())

    fun slotStart() {
        setAmount()
        printCoins()
        setProduct()
    }

    private fun setAmount() {
        vendingMachine.generateCoins(inputView.vendingMachineAmount())
    }

    private fun printCoins() {
        outputView.vendingMachinCoin(vendingMachine.coins)
    }

    private fun setProduct() {
        vendingMachine.setProduct(inputView.vendingMachinProduct())
    }


}