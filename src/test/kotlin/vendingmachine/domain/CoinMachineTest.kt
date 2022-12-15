package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import vendingmachine.domain.model.Coins
import java.lang.IllegalArgumentException

class CoinMachineTest {

    private lateinit var coinMachine: CoinMachine

    @BeforeEach
    fun setUp() {
        coinMachine = CoinMachine(CustomCoinGenerator())
    }

    @Test
    @DisplayName("코인 머신이 올바른 코인클래스를 반환하는지 테스트합니다.")
    fun generateCoinsTest() {
        val coins = Coins()
        coins.slotCoin(500)
        coins.slotCoin(100)
        coins.slotCoin(10)
        coins.slotCoin(50)
        assertThat(coinMachine.generateCoins(660).count()).isEqualTo(coins.count())
    }

    @ParameterizedTest
    @ValueSource(strings = ["2004", "4", "0"])
    @DisplayName("총 금액이 10원 단위가 아니면 에러를 발생합니다.")
    fun validateAmount(amount: Int) {
        assertThrows<IllegalArgumentException> {
            coinMachine.generateCoins(amount)
        }
    }

    inner class CustomCoinGenerator : CoinGenerator {
        private val coinsList = mutableListOf(500, 100, 10, 50, 10)
        override fun generateRandomCoin(amount: Int): Int {
            return coinsList.removeAt(0)
        }
    }

}