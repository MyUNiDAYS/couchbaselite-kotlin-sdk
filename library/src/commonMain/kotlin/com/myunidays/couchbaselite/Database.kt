package com.myunidays.couchbaselite

expect class Database(name: String, configuration: DatabaseConfiguration = DatabaseConfiguration()) {
    val name: String
    val path: String?
    fun createCollection(name: String) : Collection?
    fun createQuery(query: String): Query?
    fun delete()
    fun getCollection(collectionName: String, scopeName: String? = null): Collection?
}