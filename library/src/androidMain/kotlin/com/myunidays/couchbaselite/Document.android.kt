package com.myunidays.couchbaselite

actual open class Document internal constructor(open val android: com.couchbase.lite.Document) {
    actual val id: String
        get() = android.id
    actual val collection: Collection?
        get() = android.collection?.let { Collection(it) }
    actual val revisionID: String?
        get() = android.revisionID
    actual val sequence: Long
        get() = android.sequence
    actual fun toMutable(): MutableDocument =
        MutableDocument(android.toMutable())
}