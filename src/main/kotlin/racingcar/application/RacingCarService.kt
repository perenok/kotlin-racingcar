package racingcar.application

import racingcar.domain.*

class RacingCarService {

    fun race(carNames: List<String>, tryNumber: Int): List<String> {
        val cars = createCars(carNames)
        val strategy = RandomMoveStrategy()
        repeat(tryNumber){
            cars.moveAll(strategy)
        }

        val maxPosition = cars.calculateMaxPosition()
        return cars.findCarsBySamePosition(maxPosition)
            .map { it.getName() }
    }

    private fun createCars(carNames: List<String>): Cars {
        return Cars(carNames.map { Car(CarName(it)) })
    }
}