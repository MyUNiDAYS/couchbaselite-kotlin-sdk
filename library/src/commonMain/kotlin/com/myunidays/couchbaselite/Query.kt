package com.myunidays.couchbaselite

expect class Query {
    val parameters: Parameters?
    fun execute(): ResultSet?
    fun explain(): String?
    fun addChangeListener(listener: QueryChangeListener)
}
