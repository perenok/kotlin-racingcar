package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import racingcar.domain.strategy.MustMoveStrategy

internal class CarsTest : AnnotationSpec() {

    private var car1 = Car(CarName("jason"))
    private var car2 = Car(CarName("pobby"))
    private var car3 = Car(CarName("inbi"))
    private val carList = listOf(car1, car2, car3)

    @Test
    fun `Cars 생성 및 초기화`() {
        //given - when
        val cars = Cars()
        cars.addAll(carList)

        //then
        cars.getCars() shouldHaveSize 3
    }


    @Test
    fun `Cars 중에 가장 큰 position 을 계산`() {
        //given
        car1 = car1.move(MustMoveStrategy())
        car1 = car1.move(MustMoveStrategy())
        car2 = car2.move(MustMoveStrategy())
        val cars = Cars()
        cars.addAll(listOf(car1, car2, car3))

        //when
        val expected = cars.calculateMaxPosition()

        //then
        expected shouldBe 2
    }

    @Test
    fun `가장 먼 거리를 간 자동차들을 찾는다`() {
        //given
        car1 = car1.move(MustMoveStrategy())
        car1 = car1.move(MustMoveStrategy())
        car2 = car2.move(MustMoveStrategy())
        val cars = Cars()
        cars.addAll(listOf(car1, car2, car3))
        val maxPosition = cars.calculateMaxPosition()

        //when
        val expected = cars.findCarsBySamePosition(maxPosition)

        //then
        expected shouldHaveSize 1
        expected[0] shouldBe car1
    }
}