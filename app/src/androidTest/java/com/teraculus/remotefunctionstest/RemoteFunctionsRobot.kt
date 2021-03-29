package com.teraculus.remotefunctionstest

import com.google.common.truth.Truth
import com.teraculus.remotefunctions.domain.core.CoreException
import com.teraculus.remotefunctions.domain.controller.ControllerFunction
import com.teraculus.remotefunctions.domain.model.BooleanFunc
import com.teraculus.remotefunctions.domain.model.DoubleFunc
import com.teraculus.remotefunctions.domain.model.IntFunc
import com.teraculus.remotefunctions.domain.model.StringFunc
import com.teraculus.remotefunctionstest.Stubs
import junit.framework.Assert.assertEquals
import org.junit.Assert.assertThrows


object RemoteFunctionsRobot {


    private lateinit var controllerFunction: ControllerFunction

    class RemoteFunctionsRobotArrange {

        fun setUpFunctionString() {
            controllerFunction = ControllerFunction(Stubs.functionString)
        }

        fun setUpFunctionInt() {
            controllerFunction = ControllerFunction(Stubs.functionInt)
        }

        fun setUpFunctionDouble() {
            controllerFunction = ControllerFunction(Stubs.functionDouble)
        }

        fun setUpFunctionBooelan() {
            controllerFunction = ControllerFunction(Stubs.functionBoolean)
        }

        fun setUpFunctionParam() {
            controllerFunction = ControllerFunction(Stubs.functionAll)
        }

        fun setUpFunctionIncomplete() {
            controllerFunction = ControllerFunction(Stubs.functionIncomplete)
        }
    }

    class RemoteFunctionsRobotAct {

        private fun setNameFunction(nameFunction: String) {
            controllerFunction.nameFunction(nameFunction)
        }

        private fun setParams(param: String, paramSet: String) {
            controllerFunction.addParam(param, paramSet)
        }

        private fun setConfigWithdrawalParams() {
            setParams("VALOR_SAQUE", "1000")
        }

        private fun setConfigApplyTaxParams() {
            setParams("VALOR_TOTAL", "500")
            setParams("VALOR_BONUS", "10")
        }

        fun setConfigWithdrawal() {
            setConfigWithdrawalParams()
            setNameFunction("isSaqueAprovado()")
        }


        fun setConfigApplyTax() {
            setConfigApplyTaxParams()
            setNameFunction("aplicarTaxa()")
        }

        fun setReplaceAllParams() {
            controllerFunction.forceReplaceAllParams(true)
        }
    }

    class RemoteFunctionsRobotAssert {

        private fun isResultString(): String {
            val anyString = controllerFunction.build<StringFunc>()
            return anyString.toResult()

        }

        private fun isResultInt(): Int {
            val anyInt = controllerFunction.build<IntFunc>()
            return anyInt.toResult()
        }

        private fun isResultBoolean(): Boolean {
            val anyBoolean = controllerFunction.build<BooleanFunc>()
            return anyBoolean.toResult()
        }

        private fun isResultDouble(): Double {
            val anyDouble = controllerFunction.build<DoubleFunc>()
            return anyDouble.toResult()
        }

        fun isResultName() {
            val expected = "Higor"
            val name = isResultString()
            Truth.assertThat(expected).isEqualTo(name)
        }

        fun isResultSumInt() {

            val expected = 20
            val value = isResultInt()
            Truth.assertThat(expected).isEqualTo(value)
        }

        fun isResultPiDouble() {

            val expected = 3.14
            val value = isResultDouble()
            Truth.assertThat(expected).isEqualTo(value)
        }

        fun isResultCheckBoolean() {

            val expected = true
            val value = isResultBoolean()
            Truth.assertThat(expected).isEqualTo(value)
        }

        fun isCheckdWithdrawal() {
            val expected = false
            val value = isResultBoolean()
            Truth.assertThat(expected).isEqualTo(value)
        }

        fun isCheckApplyTax() {
            val expected = 15.30
            val value = isResultDouble()

            assertEquals(expected, value, 0.00001)

        }

        fun isCheckExceptionNoReplaceAllParams() {

            val thrown = assertThrows(CoreException::class.java) { isResultDouble() }
            val exptecedMessage = "Existem parametros que não foram preenchidos"

            Truth.assertThat(thrown).isInstanceOf(CoreException::class.java)
            Truth.assertThat(thrown.msg).contains(exptecedMessage)
        }

        fun isCheckExceptionJavaScriptIncomplete() {

            val thrown = assertThrows(CoreException::class.java) { isResultDouble() }
            val exptecedMessage =
                "Não foi possível executar a função: Isso pode acontecer quando o tipo do retorno não foi o esperado ou a função Java Script não está correta"

            Truth.assertThat(thrown).isInstanceOf(CoreException::class.java)
            Truth.assertThat(thrown.msg).contains(exptecedMessage)
        }

    }

    fun arrange(func: RemoteFunctionsRobotArrange.() -> Unit) =
        RemoteFunctionsRobotArrange().apply(func)

    fun act(func: RemoteFunctionsRobotAct.() -> Unit) = RemoteFunctionsRobotAct().apply(func)
    fun assert(func: RemoteFunctionsRobotAssert.() -> Unit) =
        RemoteFunctionsRobotAssert().apply(func)

}