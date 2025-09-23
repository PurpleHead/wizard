package at.meandthebois.wizard.domain.game.exception

import org.springframework.http.HttpStatus

class MissingPlayersException(
    val httpStatus: HttpStatus = HttpStatus.BAD_REQUEST,
    override var message: String
) : RuntimeException()