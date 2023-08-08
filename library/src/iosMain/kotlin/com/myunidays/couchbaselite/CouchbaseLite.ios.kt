package com.myunidays.couchbaselite

actual object CouchbaseLite {
    actual fun init(context: Any?, logLevel: LogLevel) {
        val log = cocoapods.CouchbaseLite.CBLDatabase.log()
        log.console.setLevel(logLevel.toNative())
    }
}
