package com.myunidays.couchbaselite

import com.couchbase.lite.collectionChangeFlow
import com.couchbase.lite.documentChangeFlow
import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.Executor

actual class Collection internal constructor(val android: com.couchbase.lite.Collection){
    actual val name: String get() = android.name
    actual val count: Long get() = android.count
    actual val scope: Scope
        get() = Scope(android.scope)
    actual val indexes: Set<String>
        get() = android.indexes

    actual fun save(document: MutableDocument) {
        android.save(document.android)
    }
    actual fun delete(document: Document) {
        android.delete(document.android)
    }
    actual fun purge(document: Document) {
        android.purge(document.android)
    }
    actual fun createIndex(name: String, index: Index) {
        android.createIndex(name, index.android)
    }
    actual fun deleteIndex(name: String) {
        android.deleteIndex(name)
    }

    actual fun addDocumentChangeListener(
        id: String,
        listener: DocumentChangeListener
    ) : ListenerToken = ListenerToken(android.addDocumentChangeListener(id, listener.android))

    fun collectionChangeFlow() = android.collectionChangeFlow()
    actual fun documentChangeFlow(documentId: String) = android.documentChangeFlow(documentId)
}