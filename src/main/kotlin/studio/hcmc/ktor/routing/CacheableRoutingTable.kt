package studio.hcmc.ktor.routing

import studio.hcmc.kotlin.protocol.Id

interface CacheableRoutingTable<Element, ElementId : Id<IdValue>, IdValue> : RoutingTable {
    val cacheHandler: CacheHandler<Element, ElementId, IdValue>?

    interface CacheHandler<Element, ElementId : Id<IdValue>, IdValue> {
        suspend fun add(id: ElementId, value: Element)

        suspend fun set(id: ElementId, value: Element)

        suspend fun remove(id: ElementId)

        suspend fun get(id: ElementId): Element?
    }
}