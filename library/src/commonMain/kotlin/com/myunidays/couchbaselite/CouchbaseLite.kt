package com.myunidays.couchbaselite

expect object CouchbaseLite {
    fun init(context: Any? = null, logLevel: LogLevel = LogLevel.NONE)
}
