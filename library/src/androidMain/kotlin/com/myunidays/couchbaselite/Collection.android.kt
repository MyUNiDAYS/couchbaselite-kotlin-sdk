package com.myunidays.couchbaselite

actual class Collection internal constructor(val android: com.couchbase.lite.Collection){

    actual val name: String get() = android.name
    actual val count: Long get() = android.count
    actual fun save(document: MutableDocument) {
        android.save(document.android)
    }
}