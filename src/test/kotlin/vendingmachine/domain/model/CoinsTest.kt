package vendingmachine.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CoinsTest {

    private lateinit var coins: Coins

    @BeforeEach
    fun setup() {
        coins = Coins()
    }

    @Test
    @DisplayName("모든 코인 입력을 테스트한다.")
    fun totalSlotCoinTest() {
        coins.slotCoin(500)
        coins.slotCoin(100)
        coins.slotCoin(50)
        coins.slotCoin(10)
        coins.slotCoin(10)
        coins.slotCoin(100)
        assertThat(coins.count()).isEqualTo(listOf(1, 2, 1, 2))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "20", "0", "501"])
    @DisplayName("코인 단위가 맞지 않을 때 오류가 발생한다.")
    fun validateCoinUnit(coin: Int) {
        assertThrows<IllegalArgumentException> {
            coins.slotCoin(coin)
        }
    }
}


