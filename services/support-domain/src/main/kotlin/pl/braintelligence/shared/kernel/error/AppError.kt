package pl.braintelligence.shared.kernel.error

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.zalando.problem.Status

open class AppError(
    override val title: String,
    open val status: Status? = null,
    root: AppThrowableError? = null
) : AppThrowableError(title, root)

@JsonIgnoreProperties("suppressed", ignoreUnknown = true)
open class AppThrowableError(open val title: String?, cause: Throwable?) : RuntimeException(title, cause) {

    @JsonIgnore
    override fun getStackTrace(): Array<StackTraceElement> = super.getStackTrace()

    @JsonIgnore
    override fun getLocalizedMessage(): String = super.getLocalizedMessage()

    @get:JsonIgnore
    override val cause: Throwable? get() = super.cause

    @get:JsonIgnore
    override val message: String? get() = super.message
}
