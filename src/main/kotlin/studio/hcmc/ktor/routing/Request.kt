package studio.hcmc.ktor.routing

import io.ktor.server.application.*
import io.ktor.server.request.*

suspend fun ApplicationCall.receiveBytes(): ByteArray {
    val contentLength = request.contentLength()?.toInt() ?: return byteArrayOf()
    val bytes = ByteArray(contentLength)
    val channel = receiveChannel()
    var offset = 0
    do {
        val size = channel.readAvailable(bytes, offset, bytes.size)
        offset += size
    } while (size > 0)

    return bytes
}