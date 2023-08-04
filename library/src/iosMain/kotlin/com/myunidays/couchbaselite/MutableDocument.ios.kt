package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(val ios: cocoapods.CouchbaseLite.CBLMutableDocument) {
    actual companion object {
        actual fun setJSON(json: String): MutableDocument =
            MutableDocument(cocoapods.CouchbaseLite.CBLMutableDocument(json))
    }
}
