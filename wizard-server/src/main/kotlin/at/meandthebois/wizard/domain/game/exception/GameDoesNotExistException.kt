package at.meandthebois.wizard.domain.game.exception

import at.meandthebois.wizard.domain.shared.exception.ClientFacingException
import org.springframework.http.HttpStatus

class GameDoesNotExistException(
    override val message: String
) : ClientFacingException(httpStatus = HttpStatus.NOT_FOUND, message)