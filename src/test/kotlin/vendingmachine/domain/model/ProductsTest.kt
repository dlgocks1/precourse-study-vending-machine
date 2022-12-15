package vendingmachine.domain.model

import org.assertj.core.api.Assertions.assertThat

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class ProductsTest {

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