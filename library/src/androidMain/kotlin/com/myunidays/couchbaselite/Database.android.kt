package com.myunidays.couchbaselite

actual class Database actual constructor(name: String, configuration: DatabaseConfiguration) {
    val android = com.couchbase.lite.Database(name, configuration.android)
    actual val name: String get() = android.name
    actual val path: String? get() = android.path
    actual val collections: Set<Collection>
        get() = android.collections.map { Collection(it) }.toSet()
    actual val config: DatabaseConfiguration
        get() = DatabaseConfiguration(android.config)
    actual val scopes: Set<Scope>
        get() = android.scopes.map { Scope(it) }.toSet()
    actual val defaultCollection: Collection?
        get() = android.defaultCollection?.let { Collection(it) }
    actual val defaultScope: Scope?
        get() = Scope(android.defaultScope)

    actual fun createCollection(name: String): Collection? =
        Collection(android.createCollection(name))
    actual fun getCollection(
        collectionName: String,
        scopeName: String?
    ): Collection? = android.getCollection(collectionName, scopeName)?.let { Collection(it) }

    actual fun createQuery(query: String): Query? =
        Query(android.createQuery(query))

    actual fun delete() {
        android.delete()
    }
    actual fun deleteCollection(collectionName: String, scope: String?) {
        android.deleteCollection(collectionName, scope)
    }
}