package vendingmachine.controller

import vendingmachine.domain.RandomCoinGenerator
import vendingmachine.domain.model.Money
import vendingmachine.domain.model.VendingMachine
import vendingmachine.view.InputView
import vendingmachine.view.OutputView

class VendingMachineController(
    private val inputView: InputView,
    private val outputView: OutputView
) {

    private val vendingMachine = VendingMachine(RandomCoinGenerator())
    private lateinit var userMoney: Money

    fun slotStart() {
        setAmount()
        setProduct()
        setUserAmount()
        purchaseProduct()
        returnChange()
    }

    private fun returnChange() {
        outputView.returnChange(vendingMachine.returnChange(userMoney))
    }

    private fun purchaseProduct() {
        while (userMoney.lessThan(vendingMachine.getProductsMinPrize())
            || vendingMachine.isSoldOut()
        ) {
            userMoney.spend(vendingMachine.purchase(inputView.purchaseProduct(userMoney)))
        }
    }

    private fun setAmount() {
        vendingMachine.generateCoins(inputView.vendingMachineAmount())
        printCoins()
    }

    private fun printCoins() {
        outputView.vendingMachinCoin(vendingMachine.coins)
    }

    private fun setProduct() {
        vendingMachine.setProduct(inputView.vendingMachinProduct())
    }

    private fun setUserAmount() {
        userMoney = Money(inputView.userAmount())
    }

}