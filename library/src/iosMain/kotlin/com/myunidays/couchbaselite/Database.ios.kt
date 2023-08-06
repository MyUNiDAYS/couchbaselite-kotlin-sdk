package com.myunidays.couchbaselite

import cocoapods.CouchbaseLite.CBLCollection
import cocoapods.CouchbaseLite.CBLScope

actual class Database actual constructor(name: String, configuration: DatabaseConfiguration) {
    lateinit var ios : cocoapods.CouchbaseLite.CBLDatabase
    actual val name: String get() = ios.name
    actual val path: String? get() = ios.path

    actual val collections: Set<Collection>
        get() = ios.collections(null, null)
            ?.mapNotNull { collection ->
                (collection as? CBLCollection)?.let { Collection(it) }
            }
            ?.toSet()
            ?: emptySet()
    actual val config: DatabaseConfiguration
        get() = DatabaseConfiguration(ios.config)
    actual val scopes: Set<Scope>
        get() = ios.scopes(null)
            ?.mapNotNull { scope ->
                (scope as? CBLScope)?.let { Scope(it) }
            }
            ?.toSet()
            ?: emptySet()
    actual val defaultCollection: Collection?
        get() = ios.defaultCollection(null)?.let { Collection(it) }
    actual val defaultScope: Scope?
        get() = ios.defaultScope(null)?.let { Scope(it) }
    init {
        throwError { error ->
            ios = cocoapods.CouchbaseLite.CBLDatabase(name, configuration.ios, error = error)
        }
    }
    actual fun createCollection(name: String): Collection? =
        ios.createCollectionWithName(name, null, null)?.let { Collection(it) }

    actual fun getCollection(
        collectionName: String,
        scopeName: String?
    ): Collection? = ios.collectionWithName(collectionName, scopeName, null)?.let { Collection(it) }

    actual fun createQuery(query: String): Query? =
        ios.createQuery(query, null)?.let { Query(it) }

    actual fun delete() {
        ios.delete(null)
    }
    actual fun deleteCollection(collectionName: String, scope: String?) {
        ios.deleteCollectionWithName(collectionName, scope, null)
    }
}
