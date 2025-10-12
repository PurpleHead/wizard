package at.meandthebois.wizard.web

import at.meandthebois.wizard.domain.shared.exception.ClientFacingException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorControllerAdvice {

    @ExceptionHandler(ClientFacingException::class)
    fun handle(exception: ClientFacingException): ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(exception.httpStatus)
            .body(ErrorResponse(exception.message))
    }

}

data class ErrorResponse(
    val message: String
)