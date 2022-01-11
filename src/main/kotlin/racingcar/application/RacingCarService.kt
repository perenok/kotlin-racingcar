package racingcar.application

import racingcar.application.dto.CarDto
import racingcar.domain.Car
import racingcar.domain.CarName
import racingcar.domain.Cars
import racingcar.domain.RandomMoveStrategy

class RacingCarService(
    carNames: List<String>,
) {
    private val cars: Cars = Cars()

    init {
        cars.addAll(createCars(carNames))
    }

    fun race(): List<CarDto> {
        cars.moveAll(RandomMoveStrategy())
        return cars.getCars()
    }

    fun getWinners(): List<String> {
        val maxPosition = cars.calculateMaxPosition()
        return cars.findCarsBySamePosition(maxPosition)
            .map { it.getName() }
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { Car(CarName(it)) }
    }
}