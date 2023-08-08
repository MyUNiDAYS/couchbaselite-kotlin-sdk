package com.myunidays.couchbaselite

import com.rickclephas.kmp.nserrorkt.asThrowable
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.pointed
import kotlinx.cinterop.value
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
