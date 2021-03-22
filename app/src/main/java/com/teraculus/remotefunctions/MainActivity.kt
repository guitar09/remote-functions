package com.teraculus.remotefunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.teraculus.remotefunctions.domain.controller.ControllerFunction
import com.teraculus.remotefunctions.domain.model.IntFunc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var teste = ControllerFunction("var a = 10 + 10; a;").build<IntFunc>()

        Log.e("ControllerFunction", teste.toResult().toString())


        var printFunction =  ControllerFunction("function nomeCompleto() {return '[nome] [sobrenome]';} function soma() {return [valor] + [valor2];} #FUNCTION_NAME#")
            .addParam("valor", "10")
            .addParam("valor2", "2")
            //.nameFunction("soma()")
            //.printFunction()


            //var testeString =  ControllerFunction("function nomeCompleto() {return '[nome] [sobrenome]';} #FUNCTION_NAME#")
            .addParam("nome", "Higor")
            .addParam("sobrenome", "Natã")
            //.addParam("sssss", "Natã")
            //.addParam("dddd", "Natã")
            .forceReplaceAllParams(true)
            .nameFunction("soma()")
            .build<IntFunc>()

        Log.e("ControllerFunction", printFunction.toResult().toString())

/*        Log.e("ControllerFunction", printFunction)


        var testInt =  ControllerFunction("function soma() {return [valor] + [valor2];} #FUNCTION_NAME#")
                .addParam("valor", "10")
                .addParam("valor2", "2")
                .nameFunction("soma()")
                .build<IntFunc>()

        Log.e("ControllerFunction", testInt.toResult().toString())


        var testeDouble =  ControllerFunction("function soma() {return [valor] + [valor2];} #FUNCTION_NAME#")
                .addParam("valor", "10.50")
                .addParam("valor2", "2.50")
                .nameFunction("soma()")
                .build<DoubleFunc>()

        Log.e("ControllerFunction", testeDouble.toResult().toString())


        var testeString =  ControllerFunction("function nomeCompleto() {return '[nome] [sobrenome]';} #FUNCTION_NAME#")
                .addParam("nome", "Higor")
                .addParam("sobrenome", "Natã")
                .nameFunction("nomeCompleto()")
                .build<StringFunc>()

        Log.e("ControllerFunction", testeString.toResult())

        var testeBoolean =  ControllerFunction("function nomeCompleto() {return (1 + 1 == 3);} #FUNCTION_NAME#")
                .nameFunction("nomeCompleto()")
                .build<BooleanFunc>()

        Log.e("ControllerFunction", testeBoolean.toResult().toString())*/



/*
        var lista = HashMap<Param, ParamSet>()
        lista.put(Param("[valor]"), ParamSet("10"))
        lista.put(Param("[valor2]"), ParamSet("2"))
*/

        //var testeControllerOutro = ControllerFunctionOutro().getInt("function soma() {return [valor] + [valor2];} #FUNCTION_NAME#", lista, "soma()")
        //Log.e("ControllerFunctionOutro", testeControllerOutro.toString())
    }
}