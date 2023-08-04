package com.myunidays.couchbaselite


actual object CouchbaseLite {
    actual fun init(context: Any?) {    // change to pass in log level here.
        val log = cocoapods.CouchbaseLite.CBLDatabase.log()
        log.console.setLevel(cocoapods.CouchbaseLite.CBLLogLevel.kCBLLogLevelVerbose)
    }
}
