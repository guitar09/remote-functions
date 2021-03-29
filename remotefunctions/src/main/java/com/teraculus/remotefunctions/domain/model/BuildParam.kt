package com.teraculus.remotefunctions.domain.model

class BuildParam {

    companion object {
        fun build(param : String) : String {
            return "["+ param + "]";
        }
    }
}