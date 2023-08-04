package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(val android: com.couchbase.lite.MutableDocument) {

    actual companion object {
        actual fun setJSON(json: String): MutableDocument =
            MutableDocument(com.couchbase.lite.MutableDocument(json))
    }
}