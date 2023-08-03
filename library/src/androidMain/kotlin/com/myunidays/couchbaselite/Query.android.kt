package com.myunidays.couchbaselite

actual class Query internal constructor(private val android: com.couchbase.lite.Query){
    actual fun execute(): ResultSet? = ResultSet(android.execute())
}