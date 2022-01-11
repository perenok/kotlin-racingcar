package racingcar.domain

import racingcar.application.dto.CarDto

class Cars {
    private val cars: MutableList<Car> = mutableListOf()

    fun addAll(cars: List<Car>) {
        this.cars.addAll(cars)
    }

    fun moveAll(moveStrategy: MoveStrategy) {
        cars.replaceAll { it.move(moveStrategy) }
    }

    fun calculateMaxPosition(): Int {
        return cars.maxByOrNull { it.position }?.position ?: 0
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
    }

    fun getCars(): List<CarDto> {
        return cars.map { CarDto(it.getName(), it.position) }
    }
}