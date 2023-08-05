package com.myunidays.couchbaselite

actual class Database actual constructor(name: String, configuration: DatabaseConfiguration) {
    val android = com.couchbase.lite.Database(name, configuration.android)
    actual val name: String get() = android.name
    actual val path: String? get() = android.path
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
}