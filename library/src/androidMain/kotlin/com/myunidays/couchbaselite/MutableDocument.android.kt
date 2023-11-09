package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(override val android: com.couchbase.lite.MutableDocument) :
    Document(android) {
    actual fun setJSON(json: String) {
        android.setJSON(json)
    }
    actual fun setBoolean(key: String, value: Boolean) {
        android.setBoolean(key, value)
    }
    actual fun setDouble(key: String, value: Double) {
        android.setDouble(key, value)
    }
    actual fun setFloat(key: String, value: Float) {
        android.setFloat(key, value)
    }
    actual fun setInt(key: String, value: Int) {
        android.setInt(key, value)
    }
    actual fun setString(key: String, value: String) {
        android.setString(key, value)
    }
    actual companion object {
        actual fun setJSON(id: String?, json: String): MutableDocument =
            MutableDocument(com.couchbase.lite.MutableDocument(id, json))
    }
}
