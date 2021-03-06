package com.example.plot_app

import jetbrains.datalore.plot.PlotHtmlExport
import jetbrains.letsPlot.Stat
import jetbrains.letsPlot.geom.geom_bar
import jetbrains.letsPlot.intern.Plot
import jetbrains.letsPlot.intern.toSpec
import jetbrains.letsPlot.lets_plot


class grafica(countA : Int, countB : Int){


    val datos = mutableMapOf<String,Any>(
        "Category" to listOf("Cat A", "Cat B"),
        "Counts" to listOf(countA, countB)
    )

    var z = lets_plot(datos)

    val layer = geom_bar(stat = Stat.identity){
        x = "Category"
        y = "Counts"
        fill = "Category"
    }

    val graph : Plot = (z + layer)

    var buffer = StringBuffer()

    var ht = PlotHtmlExport.buildHtmlFromRawSpecs(graph.toSpec())

    var buffer2str : String = ""

    fun assemble(){
        buffer.append("$ht")

        buffer2str = buffer.toString()
    }
}