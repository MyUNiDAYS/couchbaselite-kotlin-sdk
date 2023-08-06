package com.myunidays.couchbaselite

actual class MutableDocument internal constructor(override val ios: cocoapods.CouchbaseLite.CBLMutableDocument) : Document(ios) {
    actual fun setJSON(json: String) {
        ios.setJSON(json, null)
    }
    actual fun setBoolean(key: String, value: Boolean) {
        ios.setBoolean(value, key)
    }
    actual fun setDouble(key: String, value: Double) {
        ios.setDouble(value, key)
    }
    actual fun setFloat(key: String, value: Float) {
        ios.setFloat(value, key)
    }
    actual fun setInt(key: String, value: Int) {
        ios.setInteger(value.toLong(), key)
    }

    actual fun setString(key: String, value: String) {
        ios.setString(value, key)
    }
    actual companion object {
        actual fun setJSON(json: String): MutableDocument =
            MutableDocument(cocoapods.CouchbaseLite.CBLMutableDocument(json))
    }
}
