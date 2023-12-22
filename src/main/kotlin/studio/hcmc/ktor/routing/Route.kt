package studio.hcmc.ktor.routing

import io.ktor.server.routing.*

fun interface Route {
    operator fun invoke(routing: Routing)
}