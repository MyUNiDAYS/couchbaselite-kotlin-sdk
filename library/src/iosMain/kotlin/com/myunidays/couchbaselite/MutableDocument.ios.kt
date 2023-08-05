package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(override val ios: cocoapods.CouchbaseLite.CBLMutableDocument) : Document(ios) {
    actual companion object {
        actual fun setJSON(json: String): MutableDocument =
            MutableDocument(cocoapods.CouchbaseLite.CBLMutableDocument(json))
    }
}
