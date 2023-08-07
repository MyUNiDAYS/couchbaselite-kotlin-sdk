package com.myunidays.couchbaselite

expect class Result {
    val keys: List<String>
    fun toJSON(): String
    fun getDictionary(index: Int): Dictionary?
}