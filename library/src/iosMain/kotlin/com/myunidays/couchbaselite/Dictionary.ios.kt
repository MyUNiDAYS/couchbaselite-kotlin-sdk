package com.myunidays.couchbaselite

actual class Dictionary internal constructor(val ios: cocoapods.CouchbaseLite.CBLDictionary) {
    actual override fun toString(): String = ios.toString()
    actual fun toJSON(): String = ios.toJSON()
}