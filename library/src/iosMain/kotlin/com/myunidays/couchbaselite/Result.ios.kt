package com.myunidays.couchbaselite

actual class Result internal constructor(private val ios: cocoapods.CouchbaseLite.CBLQueryResult) {
    actual fun toJSON(): String = ios.toJSON()
}
