package com.myunidays.couchbaselite

actual class Database actual constructor(name: String, configuration: DatabaseConfiguration) {
    lateinit var ios : cocoapods.CouchbaseLite.CBLDatabase
    actual val name: String get() = ios.name
    actual val path: String? get() = ios.path

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
}
