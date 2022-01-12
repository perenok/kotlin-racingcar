package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.strategy.MustMoveStrategy

internal class CarSpec : AnnotationSpec() {

    @Test
    fun `car 생성한다`() {
        //given - when
        val car = Car(CarName("jason"))

        //then
        car.getName() shouldBe "jason"
        car.position shouldBe 0
    }

    @Test
    fun `car 움직인다`() {
        //given
        var car = Car(CarName("jason"))

        //when
        car = car.move(MustMoveStrategy())

        //then
        car.getName() shouldBe "jason"
        car.position shouldBe 1
    }

    @Test
    fun `같은 position 인지 확인`() {
        //given
        var car1 = Car(CarName("jason"))
        var car2 = Car(CarName("pobby"))
        car1 = car1.move(MustMoveStrategy())
        car2 = car2.move(MustMoveStrategy())

        //when
        val expected = car1.isSamePosition(car2.position)

        //then
        expected shouldBe true
        car1.position shouldBe 1
        car2.position shouldBe 1
    }
}