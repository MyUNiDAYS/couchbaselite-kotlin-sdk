package com.myunidays.couchbaselite

actual open class SelectResult internal constructor(val ios: cocoapods.CouchbaseLite.CBLQuerySelectResult) {
    actual companion object {
        actual fun all(): SelectResult.From =
            From(cocoapods.CouchbaseLite.CBLQuerySelectResult.all())
    }

    actual class From internal constructor(ios: cocoapods.CouchbaseLite.CBLQuerySelectResult) : SelectResult(ios)

    actual class As internal constructor(ios: cocoapods.CouchbaseLite.CBLQuerySelectResult) : SelectResult(ios)
}
