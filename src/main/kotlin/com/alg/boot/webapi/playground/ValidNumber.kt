package com.alg.boot.webapi.playground

class ValidNumber {

    fun check(o: Any?): Boolean {
        return if (o is Int) {
            o in 0..9
        } else {
            false
        }
    }
}
