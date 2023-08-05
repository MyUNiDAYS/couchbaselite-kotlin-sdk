package com.myunidays.couchbaselite

actual class Collection internal constructor(val ios: cocoapods.CouchbaseLite.CBLCollection) {
    actual val name: String get() = ios.name
    actual val count: Long get() = ios.count.toLong()
    actual val scope: Scope
        get() = Scope(ios.scope)

    actual fun save(document: MutableDocument) {
        ios.saveDocument(document.ios, null)
    }
    actual fun delete(document: Document) {
        ios.deleteDocument(document.ios, null)
    }
    actual fun purge(document: Document) {
        ios.purgeDocument(document.ios, null)
    }
}
