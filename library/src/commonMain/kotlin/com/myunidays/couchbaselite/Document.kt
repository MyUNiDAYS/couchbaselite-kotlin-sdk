package com.myunidays.couchbaselite

expect open class Document {
    val id : String
    val collection: Collection?
    val revisionID : String?
    val sequence : Long
    fun toMutable(): MutableDocument
}