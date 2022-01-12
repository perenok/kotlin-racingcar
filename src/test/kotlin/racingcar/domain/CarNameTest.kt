package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.AnnotationSpec
import racingcar.exception.CarNameException

internal class CarNameTest : AnnotationSpec() {

    @Test
    fun `이름 길이가 5를 초과하면 예외가 생긴다`() {
        shouldThrowExactly<CarNameException> {
            CarName("123456")
        }
    }
}