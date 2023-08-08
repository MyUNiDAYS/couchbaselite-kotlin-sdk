package com.myunidays.couchbaselite

expect class Database(name: String, configuration: DatabaseConfiguration = DatabaseConfiguration.default()) {
    val name: String
    val path: String?
    val collections: Set<Collection>
    val config: DatabaseConfiguration
    val scopes: Set<Scope>
    val defaultCollection: Collection?
    val defaultScope: Scope?
    fun deleteCollection(collectionName: String, scope: String?)
    fun createCollection(name: String): Collection?
    fun createQuery(query: String): Query?
    fun delete()
    fun getCollection(collectionName: String, scopeName: String? = null): Collection?
}
