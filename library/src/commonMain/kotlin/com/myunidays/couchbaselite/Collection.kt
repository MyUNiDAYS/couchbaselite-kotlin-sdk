package com.myunidays.couchbaselite

import kotlinx.coroutines.flow.Flow

expect class Collection {

    val name: String
    val count: Long
    val scope: Scope
    val indexes: Set<String>
    fun save(document: MutableDocument)
    fun delete(document: Document)
    fun purge(document: Document)

    fun createIndex(name: String, index: Index)
    fun deleteIndex(name: String)
    fun addDocumentChangeListener(id: String, listener: DocumentChangeListener) : ListenerToken
    fun documentChangeFlow(documentId: String) : Flow<DocumentChange>
}