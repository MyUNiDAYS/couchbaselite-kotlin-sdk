package com.myunidays.couchbaselite

actual open class SelectResult internal constructor(val android: com.couchbase.lite.SelectResult) {
    actual companion object {
        actual fun all(): SelectResult = SelectResult(com.couchbase.lite.SelectResult.all())
        actual fun expression(expression: Expression): SelectResult = SelectResult(com.couchbase.lite.SelectResult.expression(expression.android))
        actual fun property(property: String): SelectResult = SelectResult(com.couchbase.lite.SelectResult.property(property))
    }
}
