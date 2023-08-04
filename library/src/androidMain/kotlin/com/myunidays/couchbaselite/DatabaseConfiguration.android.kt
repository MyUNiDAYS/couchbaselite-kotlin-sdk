package com.myunidays.couchbaselite

actual class DatabaseConfiguration {
    val android = com.couchbase.lite.DatabaseConfiguration()
    actual var directory: String
        get() = android.directory
        set(value) { android.setDirectory(value) }
}