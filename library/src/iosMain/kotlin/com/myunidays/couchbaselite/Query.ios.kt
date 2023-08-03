package com.myunidays.couchbaselite

actual class Query internal constructor(private val ios: cocoapods.CouchbaseLite.CBLQuery){
    actual fun execute(): ResultSet? = ios.execute(null)?.let { ResultSet(it) }
}