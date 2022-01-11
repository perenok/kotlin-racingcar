package racingcar.domain

class Cars(val cars: List<Car>) {

    fun moveAll(moveStrategy: MoveStrategy) {
        cars.forEach { car -> car.move(moveStrategy) }
    }

    fun calculateMaxPosition(): Int {
        return cars.maxByOrNull { it.position }?.position ?: 0
    }

    fun findCarsBySamePosition(position: Int): List<Car> {
        return cars.filter { it.isSamePosition(position) }
    }
}