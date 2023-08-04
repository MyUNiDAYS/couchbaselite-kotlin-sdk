package com.myunidays.couchbaselite

actual class DatabaseConfiguration {
    val ios = cocoapods.CouchbaseLite.CBLDatabaseConfiguration()

    actual var directory: String
        get() = ios.directory
        set(value) { ios.setDirectory(value) }
}