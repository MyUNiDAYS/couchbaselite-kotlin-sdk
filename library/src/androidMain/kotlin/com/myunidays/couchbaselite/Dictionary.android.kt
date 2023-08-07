package com.myunidays.couchbaselite

actual class Dictionary internal constructor(val android: com.couchbase.lite.Dictionary) {
    actual override fun toString(): String = android.toString()
    actual fun toJSON(): String = android.toJSON()
}