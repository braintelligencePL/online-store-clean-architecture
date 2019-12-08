package pl.braintelligence.shared.kernel.arrow

import arrow.core.Either

fun <A : Throwable, B> Either<A, B>.getOrThrow(): B =
    when (this) {
        is Either.Left -> throw this.a
        is Either.Right -> this.b
    }
