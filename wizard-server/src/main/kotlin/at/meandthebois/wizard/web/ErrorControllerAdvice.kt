package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.game.exception.GameCreateException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler(GameCreateException::class)
    fun handle(exception: GameCreateException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.httpStatus)
            .body(ErrorResponse(exception.message))
    }

}

data class ErrorResponse(
    val message: String
)