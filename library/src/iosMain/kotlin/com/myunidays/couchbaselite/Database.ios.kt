package com.myunidays.couchbaselite


actual class Database actual constructor(name: String) {
    val ios = cocoapods.CouchbaseLite.CBLDatabase(name, null)
    actual val name: String get() = ios.name
    actual val path: String? get() = ios.path
}
