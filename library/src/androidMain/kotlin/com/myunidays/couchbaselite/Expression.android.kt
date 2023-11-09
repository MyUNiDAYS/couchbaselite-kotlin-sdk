package com.myunidays.couchbaselite

actual class Expression internal constructor(val android: com.couchbase.lite.Expression) {
    actual fun equalTo(expression: Expression): Expression = Expression(android.equalTo(expression.android))
    @Suppress("FunctionNaming")
    actual fun `is`(expression: Expression): Expression = Expression(android.`is`(expression.android))
    actual fun isNot(expression: Expression): Expression = Expression(android.isNot(expression.android))
    // todo need to add more

    @Suppress("TooManyFunctions")
    actual companion object {
        actual fun property(property: String): Expression = Expression(com.couchbase.lite.Expression.property(property))
        actual fun value(value: Any?): Expression = Expression(com.couchbase.lite.Expression.value(value))
        actual fun string(string: String): Expression = Expression(com.couchbase.lite.Expression.string(string))
        actual fun number(number: Number): Expression = Expression(com.couchbase.lite.Expression.number(number))
        actual fun all(): Expression = Expression(com.couchbase.lite.Expression.all())
        actual fun boolean(boolean: Boolean): Expression =
            Expression(com.couchbase.lite.Expression.booleanValue(boolean))
        actual fun double(double: Double): Expression = Expression(com.couchbase.lite.Expression.doubleValue(double))
        actual fun int(int: Int): Expression = Expression(com.couchbase.lite.Expression.intValue(int))
        actual fun float(float: Float): Expression = Expression(com.couchbase.lite.Expression.floatValue(float))
        actual fun not(expression: Expression): Expression =
            Expression(com.couchbase.lite.Expression.not(expression.android))
        actual fun negated(expression: Expression): Expression =
            Expression(com.couchbase.lite.Expression.negated(expression.android))
    }
}
