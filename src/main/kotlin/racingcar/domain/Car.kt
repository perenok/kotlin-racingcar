package racingcar.domain

class Car(
    val carName: CarName,
    val position: Int = 0,
) {
    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.canMove()) {
            return Car(carName, position + 1)
        }
        return this
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    fun getName() : String {
        return carName.name
    }
}