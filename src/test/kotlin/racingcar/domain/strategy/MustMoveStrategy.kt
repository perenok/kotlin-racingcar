package racingcar.domain.strategy

import racingcar.domain.MoveStrategy

class MustMoveStrategy : MoveStrategy{
    override fun canMove(): Boolean {
        return true
    }

}