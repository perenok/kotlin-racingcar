package racingcar.ui

import racingcar.application.RacingCarService
import racingcar.ui.view.inputCarNames
import racingcar.ui.view.inputTryNumber

class RacingCarController(private val carService: RacingCarService) {

    fun run() {
        val cars = inputCarNames()
        val tryNumber = inputTryNumber()
        val winner = carService.race(cars, tryNumber)
    }
}