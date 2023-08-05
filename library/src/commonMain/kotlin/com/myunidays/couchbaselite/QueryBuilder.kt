package com.myunidays.couchbaselite

expect object QueryBuilder {
    fun select(database: Database) : Query
    fun select(collection: Collection) : Query
    fun selectDistinct(selectResult: SelectResult, dataSource: DataSource) : Query
}