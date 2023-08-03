package com.myunidays.couchbaselite

import cocoapods.CouchbaseLite.CBLDatabase

actual object CouchbaseLite {
    actual fun init(context: Any?) {
        CBLDatabase.initWithName("mydb")
    }
}