package racingcar.exception

class CarNameException(
    message: String = "자동차 이름은 5자 이하여야 합니다.",
) : RuntimeException(message) {

}
