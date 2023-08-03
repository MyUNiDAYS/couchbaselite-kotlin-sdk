package com.myunidays.couchbaselite

actual class Database actual constructor(name: String) {
    val android = com.couchbase.lite.Database(name)
    actual val name: String get() = android.name
    actual val path: String? get() = android.path

    //collections
//    fun getCollection(name: String): Collection = Collection(android.getCollection(name))
//    init {
//        android.
//    }
}