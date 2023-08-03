package com.myunidays.couchbaselite

import kotlinx.cinterop.ExperimentalForeignApi

actual class Database actual constructor(name: String) {
    @OptIn(ExperimentalForeignApi::class)
    val ios = cocoapods.CouchbaseLite.CBLDatabase(name, null)
    actual val name: String get() = ios.name
    actual val path: String? get() = ios.path
}
