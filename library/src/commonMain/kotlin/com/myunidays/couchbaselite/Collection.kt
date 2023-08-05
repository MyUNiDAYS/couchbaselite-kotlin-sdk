package com.myunidays.couchbaselite

expect class Collection {

    val name: String
    val count: Long
    val scope: Scope
    fun save(document: MutableDocument)
    fun delete(document: Document)
    fun purge(document: Document)
}