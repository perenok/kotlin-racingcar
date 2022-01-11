package racingcar.ui

import racingcar.application.RacingCarService
import racingcar.ui.view.InputView
import racingcar.ui.view.OutputView

class RacingCarController {

    private val inputView = InputView
    private val outputView = OutputView

    fun run() {
        val carNames = inputView.inputCarNames()
        val tryNumber = inputView.inputTryNumber()
        val carService = RacingCarService(carNames)

        outputView.printResultMessage()
        repeat(tryNumber) {
            outputView.printRaceResult(carService.race())
        }
        outputView.printWinners(carService.getWinners())
    }
}