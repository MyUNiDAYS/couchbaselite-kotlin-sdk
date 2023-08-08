package com.myunidays.couchbaselite

actual open class Document internal constructor(open val ios: cocoapods.CouchbaseLite.CBLDocument) {
    actual val id: String
        get() = ios.id
    actual val collection: Collection?
        get() = ios.collection?.let { Collection(it) }
    actual val revisionID: String?
        get() = ios.revisionID
    actual val sequence: Long
        get() = ios.sequence.toLong()
    actual val keys: List<String>
        get() = ios.keys.map { it as String }
    actual fun toMutable(): MutableDocument =
        MutableDocument(ios.toMutable())
}
