package vendingmachine.util

const val COIN_UNIT_500 = 500
const val COIN_UNIT_100 = 100
const val COIN_UNIT_50 = 50
const val COIN_UNIT_10 = 10

const val ZERO = 0
const val ERROR = "[ERROR] "

const val ERR_COIN_UNIT = ERROR.plus("코인의 단위를 지켜주세요.")
const val ERR_NO_MONEY = ERROR.plus("구매할 돈이 부족합니다.")
const val ERR_NO_PRODUCT = ERROR.plus("구매할 상품이 존재하지 않습니다.")
const val ERR_SOLD_OUT = ERROR.plus("구매할 상품이 매진 상태입니다.")
const val ERR_MONEY_UNIT = ERROR.plus("금액은 10원으로 나누어 떨어져야 합니다.")

const val INPUT_MACHIN_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요."
const val INPUT_MACHIN_PRODUCT = "\n상품명과 가격, 수량을 입력해 주세요."
const val INPUT_PURCHASE_MONEY_STATUS = "\n투입 금액: %s원"
const val INPUT_PURCHASE_NAME = "구매할 상품명을 입력해 주세요."
const val INPUT_PURCHASE_MONEY = "\n투입 금액을 입력해 주세요."

const val OUTPUT_MACHIN_COIN = "\n자판기가 보유한 동전"
const val OUTPUT_MACHIN_COIN_RESULT = "%d원 - %d개"
const val OUTPUT_CHARGE = "잔돈"


