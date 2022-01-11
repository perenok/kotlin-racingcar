package racingcar.domain

import racingcar.exception.CarNameException

private const val MAX_NAME_LENGTH = 5

class CarName(
    val name: String,
) {
    init {
        if (name.length > MAX_NAME_LENGTH) {
            throw CarNameException()
        }
    }
}