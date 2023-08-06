package com.myunidays.couchbaselite

actual class DatabaseConfiguration internal constructor(val android: com.couchbase.lite.DatabaseConfiguration) {
    actual var directory: String
        get() = android.directory
        set(value) { android.setDirectory(value) }
}