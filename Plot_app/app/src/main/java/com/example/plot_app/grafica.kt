package com.example.plot_app

import jetbrains.datalore.plot.PlotHtmlExport
import jetbrains.datalore.plot.PlotHtmlHelper
import jetbrains.letsPlot.Stat
import jetbrains.letsPlot.geom.geomBar
import jetbrains.letsPlot.ggsize
import jetbrains.letsPlot.intern.Plot
import jetbrains.letsPlot.intern.toSpec
import jetbrains.letsPlot.letsPlot


class grafica(countA : Int, countB : Int){


    val datos = mutableMapOf<String,Any>(
        "Category" to listOf("Cat A", "Cat B"),
        "Counts" to listOf(countA, countB)
    )

    var z = letsPlot(datos)

    val layer = geomBar(stat = Stat.identity){
        x = "Category"
        y = "Counts"
        fill = "Category"
    }

    val graph : Plot = (z + layer + ggsize(540, 360))

    var buffer = StringBuffer()

    var scriptUrl = PlotHtmlHelper.scriptUrl("2.0.2")

    var ht = PlotHtmlExport.buildHtmlFromRawSpecs(graph.toSpec(), scriptUrl)

    var buffer2str : String = ""

    fun assemble(){
        buffer.append("$ht")

        buffer2str = buffer.toString()
    }
}