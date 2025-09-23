package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.game.exception.MissingPlayersException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler(MissingPlayersException::class)
    fun handle(exception: MissingPlayersException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.httpStatus)
            .body(ErrorResponse(exception.message))
    }

}

data class ErrorResponse(
    val message: String
)