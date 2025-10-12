package at.meandthebois.wizard.domain.shared.exception

import org.springframework.http.HttpStatus

open class ClientFacingException (
    val httpStatus: HttpStatus,
    override val message: String
): RuntimeException(message)