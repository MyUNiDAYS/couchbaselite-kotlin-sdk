package com.myunidays.couchbaselite

import platform.Foundation.NSNumber

actual class Expression internal constructor(val ios: cocoapods.CouchbaseLite.CBLQueryExpression) {

    actual fun equalTo(expression: Expression): Expression = Expression(ios.equalTo(expression.ios))
    @Suppress("FunctionNaming")
    actual fun `is`(expression: Expression): Expression = Expression(ios.`is`(expression.ios))
    actual fun isNot(expression: Expression): Expression = Expression(ios.isNot(expression.ios))

    @Suppress("TooManyFunctions")
    actual companion object {
        actual fun property(property: String): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.property(property))
        actual fun value(value: Any?): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.value(value))
        actual fun string(string: String): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.string(string))
        actual fun number(number: Number): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.number(NSNumber(number.toInt())))
        actual fun all(): Expression = Expression(cocoapods.CouchbaseLite.CBLQueryExpression.all())
        actual fun boolean(boolean: Boolean): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.boolean(boolean))
        actual fun double(double: Double): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.double(double))
        actual fun int(int: Int): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.integer(int.toLong()))
        actual fun float(float: Float): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.float(float))
        actual fun not(expression: Expression): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.not(expression.ios))
        actual fun negated(expression: Expression): Expression =
            Expression(cocoapods.CouchbaseLite.CBLQueryExpression.negated(expression.ios))
    }
}
