package com.myunidays.couchbaselite

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlin.collections.Collection

actual class Collection internal constructor(val ios: cocoapods.CouchbaseLite.CBLCollection) {
    actual val name: String get() = ios.name
    actual val count: Long get() = ios.count.toLong()
    actual val scope: Scope
        get() = Scope(ios.scope)
    actual val indexes: Set<String>
        get() = ios.indexes(null)
            ?.filterIsInstance<String>()
            ?.toSet()
            ?: emptySet()

    actual fun save(document: MutableDocument) {
        ios.saveDocument(document.ios, null)
    }
    actual fun delete(document: Document) {
        ios.deleteDocument(document.ios, null)
    }
    actual fun purge(document: Document) {
        ios.purgeDocument(document.ios, null)
    }
    actual fun createIndex(name: String, index: Index) {
        ios.createIndex(index, name, null)
    }
    actual fun deleteIndex(name: String) {
        ios.deleteIndexWithName(name, null)
    }

    actual fun addDocumentChangeListener(
        id: String,
        listener: DocumentChangeListener
    ) : ListenerToken =
        ListenerToken(ios.addDocumentChangeListenerWithID(id, listener.ios))

    actual fun documentChangeFlow(documentId: String): Flow<DocumentChange> = callbackFlow {
        val token = addDocumentChangeListener(documentId, DocumentChangeListener { change ->
            change?.let { trySend(it) }
        })
        awaitClose { token.ios.remove() }
    }
}
