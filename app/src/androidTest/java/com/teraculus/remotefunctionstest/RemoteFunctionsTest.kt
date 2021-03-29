package com.teraculus.remotefunctionstest

import com.teraculus.remotefunctionstest.RemoteFunctionsRobot.act
import com.teraculus.remotefunctionstest.RemoteFunctionsRobot.arrange
import com.teraculus.remotefunctionstest.RemoteFunctionsRobot.assert
import org.junit.Test

class RemoteFunctionsTest {

    @Test
    fun When_Call_Name_Function_Expected_String() {

        arrange {
            setUpFunctionString()
        }
        act {

        }
        assert {
            isResultName()
        }
    }

    @Test
    fun When_Call_Sum_Function_Expected_Int() {

        arrange {
            setUpFunctionInt()
        }
        act {

        }
        assert {
            isResultSumInt()
        }
    }

    @Test
    fun When_Call_Pi_Function_Expect_Double() {

        arrange {
            setUpFunctionDouble()
        }
        act {

        }
        assert {
            isResultPiDouble()
        }
    }

    @Test
    fun When_Call_Check_Function_Expect_IsTrue() {

        arrange {
            setUpFunctionBooelan()
        }
        act {

        }
        assert {
            isResultCheckBoolean()
        }
    }

    @Test
    fun When_Call_Value_Above_Withdraw_Limit_Function_Expect_False() {

        arrange {
            setUpFunctionParam()
        }
        act {
            setConfigWithdrawal()
        }
        assert {
            isCheckdWithdrawal()
        }
    }

    @Test
    fun When_Call_Fake_Bonus_Function_Expect_Double() {

        arrange {
            setUpFunctionParam()
        }
        act {
            setConfigApplyTax()
        }
        assert {
            isCheckApplyTax()
        }
    }

    @Test
    fun When_Call_Function_And_No_ReplaceAllParams_Expect_Exeception() {

        arrange {
            setUpFunctionParam()
        }
        act {
            setReplaceAllParams()
            setConfigApplyTax()
        }
        assert {
            isCheckExceptionNoReplaceAllParams()
        }
    }

    @Test
    fun When_Call_Function_JavaScript_Error_Expect_Exeception() {

        arrange {
            setUpFunctionIncomplete()
        }
        act {

        }
        assert {
            isCheckExceptionJavaScriptIncomplete()
        }
    }
}