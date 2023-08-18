package studio.hcmc.ktor.routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.*
import io.ktor.server.response.*
import kotlinx.datetime.toJavaInstant
import studio.hcmc.kotlin.protocol.Modifiable
import studio.hcmc.kotlin.protocol.io.Response
import studio.hcmc.ktor.plugin.acceptedAt

suspend fun ApplicationCall.respondEmpty(status: HttpStatusCode) {
    respond(status)
}

suspend inline fun <reified T> ApplicationCall.respondObject(status: HttpStatusCode, result: T) {
    if (result is Modifiable) {
        val lastModifiedAt = result.lastModifiedAt
        if (lastModifiedAt == null) {
            response.header(HttpHeaders.LastModified, httpDateFormat.format(result.createdAt.toJavaInstant()))
        } else {
            response.header(HttpHeaders.LastModified, httpDateFormat.format(lastModifiedAt.toJavaInstant()))
        }
    }

    respond(status, Response.Object(acceptedAt, result))
}

suspend inline fun <reified T> ApplicationCall.respondArray(status: HttpStatusCode, result: List<T>) {
    respond(status, Response.Array(acceptedAt, result))
}

suspend fun ApplicationCall.respondError(status: HttpStatusCode, throwable: Throwable) {
    respond(status, Response.Error(acceptedAt, throwable))
}