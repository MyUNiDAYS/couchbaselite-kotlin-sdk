package com.myunidays.couchbaselite

import kotlinx.cinterop.*
import platform.Foundation.NSError


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

    actual fun getCollection(name: String): Collection? =
        ios.collectionWithName(name, null, null)?.let { Collection(it) }
}
