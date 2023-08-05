package com.myunidays.couchbaselite

actual class Database actual constructor(name: String, configuration: DatabaseConfiguration) {
    val android = com.couchbase.lite.Database(name, configuration.android)
    actual val name: String get() = android.name
    actual val path: String? get() = android.path
    actual fun createCollection(name: String): Collection? =
        Collection(android.createCollection(name))

    actual fun getCollection(name: String): Collection? =
        android.getCollection(name)?.let { Collection(it) }
}