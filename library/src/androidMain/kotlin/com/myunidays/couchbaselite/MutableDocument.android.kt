package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(override val android: com.couchbase.lite.MutableDocument) : Document(android) {

    actual companion object {
        actual fun setJSON(json: String): MutableDocument =
            MutableDocument(com.couchbase.lite.MutableDocument(json))
    }

}