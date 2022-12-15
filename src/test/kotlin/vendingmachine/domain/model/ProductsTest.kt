package vendingmachine.domain.model

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class ProductsTest {

    @Test
    @DisplayName("상품을 구매하려 했을 때 해당 상품이 없으면 에러를 발생한다.")
    fun invalidProductNameTest() {
        val proudctInput = "[콜라,1500,0];[사이다,1000,10]"
        assertThrows<IllegalArgumentException> {
            Products.valueOf(proudctInput)
                .purchase("솔의눈")
        }
    }

    @Test
    @DisplayName("상품을 구매하려 했을 때 해당 상품이 매진이면 에러를 발생한다.")
    fun soldOutTest() {
        val proudctInput = "[콜라,1500,0];[사이다,1000,10]"
        assertThrows<IllegalArgumentException> {
            Products.valueOf(proudctInput)
                .purchase("콜라")
        }
    }

    @Test
    @DisplayName("상품을 구매할 때 재고가 감소하는지 테스트한다.")
    fun purchaseTest() {
        val proudctInput = "[콜라,1500,10];[사이다,1000,10]"
        assertThat(
            Products.valueOf(proudctInput).apply {
                purchase("콜라")
            }
        ).contains(Product("콜라", 1500, 9))
    }

    @Test
    @DisplayName("상품의 최소가격을 반환하는지 테스트한다.")
    fun minPrizeTest() {
        val proudctInput = "[콜라,1500,10];[사이다,1000,10]"
        assertThat(
            Products.valueOf(proudctInput).minPrize()
        ).isEqualTo(1000)
    }

    @Test
    @DisplayName("올바른 상품을 파싱하여 객체로 반환하는지 테스트한다.")
    fun validProduct() {
        val proudctInput = "[콜라,1500,20];[사이다,1000,10]"
        assertThat(Products.valueOf(proudctInput))
            .containsAll(
                listOf(
                    Product("콜라", 1500, 20),
                    Product("사이다", 1000, 10),
                )
            )
    }

    @ParameterizedTest
    @ValueSource(strings = ["[콜라,A,20]", "[사이다,200,B]"])
    @DisplayName("상품의 가격 또는 수량이 숫자가 아니면 에러를 발생한다.")
    fun invalidProduct(proudctInput: String) {
        assertThrows<IllegalArgumentException> {
            Products.valueOf(proudctInput)
        }
    }
}