package com.myunidays.couchbaselite

expect class Dictionary {
    override fun toString(): String
    fun toJSON(): String
}