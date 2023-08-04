package com.myunidays.couchbaselite

expect object QueryBuilder {
    fun select(database: Database) : Query
    fun select(collection: Collection) : Query
    fun createQuery(query: String, database: Database) : Query
}