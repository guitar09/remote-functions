package com.teraculus.remotefunctions

class Stubs {

    companion object {
        val functionString: String = "function nome() { return 'Higor';} nome();"
        val functionInt: String = "function soma() { return 10 + 10;} soma();"
        val functionDouble: String = "function pi() { return 3.14;} pi();"
        val functionBoolean: String = "function check() { return 10 == 10;} check();"
        val functionIncomplete: String = "function check() { return 10 == ;} check();"

        val functionAll =
            "function isSaqueAprovado() { var LIMITE_MAXIMO_SAQUE = 800; var saqueAprovado = [VALOR_SAQUE] <= LIMITE_MAXIMO_SAQUE;return saqueAprovado; }function aplicarTaxa() { var PERCENTUAL_TAXA = 0.03;return ([VALOR_TOTAL] + [VALOR_BONUS]) * PERCENTUAL_TAXA; }#FUNCTION_NAME#;"

    }

}