package com.myunidays.couchbaselite

import com.rickclephas.kmp.nserrorkt.asThrowable
import kotlinx.cinterop.*
import platform.Foundation.NSError

fun <T> throwError(block: (errorPointer: CPointer<ObjCObjectVar<NSError?>>) -> T): T {
    memScoped {
        val errorPointer: CPointer<ObjCObjectVar<NSError?>> = alloc<ObjCObjectVar<NSError?>>().ptr
        val result: T = block(errorPointer)
        val error: NSError? = errorPointer.pointed.value
        if (error != null) {
            throw error.asThrowable()
        } else {
            return result
        }
    }
}
