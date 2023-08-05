package com.myunidays.couchbaselite

actual class Collection internal constructor(val android: com.couchbase.lite.Collection){
    actual val name: String get() = android.name
    actual val count: Long get() = android.count
    actual val scope: Scope
        get() = Scope(android.scope)
    actual fun save(document: MutableDocument) {
        android.save(document.android)
    }
    actual fun delete(document: Document) {
        android.delete(document.android)
    }
    actual fun purge(document: Document) {
        android.purge(document.android)
    }
}