package com.myunidays.couchbaselite

actual open class SelectResult internal constructor(val ios: cocoapods.CouchbaseLite.CBLQuerySelectResult) {
    actual companion object {
        actual fun all(): SelectResult =
            SelectResult(cocoapods.CouchbaseLite.CBLQuerySelectResult.all())
        actual fun expression(expression: Expression): SelectResult =
            SelectResult(cocoapods.CouchbaseLite.CBLQuerySelectResult.expression(expression.ios))
        actual fun property(property: String): SelectResult =
            SelectResult(cocoapods.CouchbaseLite.CBLQuerySelectResult.property(property))
    }
}
