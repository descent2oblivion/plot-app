package com.example.plot_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.htmlEncode
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var gr : grafica = grafica(0 ,0)

    fun disp(view : View){

        gr = grafica(txt_cata.getText().toString().toInt(), txt_catb.getText().toString().toInt())

        gr.assemble()

        wevi.getSettings().javaScriptEnabled = true

        wevi.getSettings().builtInZoomControls = true



        wevi.loadDataWithBaseURL(null, gr.buffer2str, "text/html", "UTF-8", null)
    }
}
