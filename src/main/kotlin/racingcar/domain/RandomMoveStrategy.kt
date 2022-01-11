package racingcar.domain

import racingcar.util.generateRandomNumber

private const val MOVE_CONDITION = 4

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        return generateRandomNumber() >= MOVE_CONDITION
    }
}