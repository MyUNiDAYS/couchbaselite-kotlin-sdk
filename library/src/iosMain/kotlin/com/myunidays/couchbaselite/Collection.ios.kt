package com.myunidays.couchbaselite

actual class Collection internal constructor(val ios: cocoapods.CouchbaseLite.CBLCollection) {
    actual val name: String get() = ios.name
    actual val count: Long get() = ios.count.toLong()
    actual fun save(document: MutableDocument) {
        ios.saveDocument(document.ios, null)
    }
}
