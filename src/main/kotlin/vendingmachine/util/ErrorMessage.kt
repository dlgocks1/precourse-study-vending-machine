package vendingmachine.util

object ErrorMessage {
    const val ERR_COIN_UNIT = ERROR.plus("코인의 단위를 지켜주세요.")
    const val ERR_NO_MONEY = ERROR.plus("구매할 돈이 부족합니다.")
    const val ERR_NO_PRODUCT = ERROR.plus("구매할 상품이 존재하지 않습니다.")
    const val ERR_SOLD_OUT = ERROR.plus("구매할 상품이 매진 상태입니다.")
    const val ERR_MONEY_UNIT = ERROR.plus("금액은 10원으로 나누어 떨어져야 합니다.")

}