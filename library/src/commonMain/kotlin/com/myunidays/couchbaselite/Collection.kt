package com.myunidays.couchbaselite

expect class Collection {

    val name: String
    val count: Long
    fun save(document: MutableDocument)
}