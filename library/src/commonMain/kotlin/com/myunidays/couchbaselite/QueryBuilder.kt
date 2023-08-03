package com.myunidays.couchbaselite

expect object QueryBuilder {
    fun select(database: Database) : Query
    fun createQuery(query: String, database: Database) : Query
}