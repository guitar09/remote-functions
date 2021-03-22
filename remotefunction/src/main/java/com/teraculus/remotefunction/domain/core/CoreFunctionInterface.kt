package com.teraculus.remotefunction.domain.core

import com.teraculus.remotefunction.domain.Constants
import com.teraculus.remotefunctions.domain.core.CoreRepositoryInterface
import com.teraculus.remotefunctions.domain.model.*
import java.util.HashMap

open abstract class CoreFunctionInterface(val coreRepository: CoreRepositoryInterface) {

    protected abstract fun searchParamsFunction(function: String): List<Param>
    protected abstract fun replaceAllParam(function: String, params: HashMap<Param, ParamSet>, replaceAllParams : Boolean): String
    abstract fun getFunction(core : CoreModel): String
    protected abstract fun getReplaceFunctionName() : String


    inline fun <reified T : BaseType> getResult(core : CoreModel): T {

        var result = coreRepository.executeFunction(getFunction(core))


        try {
            when (T::class) {
                IntFunc::class -> return IntFunc(result.toString().toDouble().toInt()) as T
                DoubleFunc::class -> return DoubleFunc(result.toString().toDouble()) as T
                BooleanFunc::class -> return BooleanFunc(result as Boolean) as T
                else -> return StringFunc(result.toString()) as T
            }
        } catch (ex: Exception) {
            throw IllegalArgumentException("O Retorno da Function não procede")
        }

    }


}