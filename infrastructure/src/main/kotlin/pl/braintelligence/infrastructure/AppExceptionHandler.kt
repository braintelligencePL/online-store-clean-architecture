package pl.braintelligence.infrastructure

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.zalando.problem.Status
import pl.braintelligence.shared.kernel.error.AppError

@ControllerAdvice
class AppExceptionHandler {

    @ExceptionHandler
    fun handleError(error: AppError): ResponseEntity<AppError> =
        ResponseEntity
            .status(error.asSpringStatus())
            .contentType(MediaType.APPLICATION_JSON)
            .body(error)

}

private fun AppError.asSpringStatus(): HttpStatus = HttpStatus.valueOf(
    status?.statusCode ?: Status.INTERNAL_SERVER_ERROR.statusCode
)
