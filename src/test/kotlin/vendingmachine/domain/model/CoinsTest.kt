package vendingmachine.domain.model

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

class CoinsTest {

    lateinit var coins: Coins

    @BeforeEach
    fun setup() {
        coins = Coins()
    }

    @Test
    @DisplayName("코인 입력을 테스트한다.")
    fun slotCoin() {
        coins.slotCoin(500)
        coins.slotCoin(100)
        coins.slotCoin(100)
        coins.slotCoin(50)
        assertThat(coins.count()).isEqualTo(listOf(1, 2, 1, 0))
    }
}