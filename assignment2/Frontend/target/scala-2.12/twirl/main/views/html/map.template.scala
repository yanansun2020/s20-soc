
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import com.fasterxml.jackson.databind.JsonNode

object map extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[JsonNode],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(message: List[JsonNode]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Map</title>
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
    integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
    crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
            integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
            crossorigin=""></script>
        <meta charset="UTF-8">
        <style type="text/css">
                #mapid """),format.raw/*15.24*/("""{"""),format.raw/*15.25*/(""" """),format.raw/*15.26*/("""height: 300px; width: 100% """),format.raw/*15.53*/("""}"""),format.raw/*15.54*/("""
        """),format.raw/*16.9*/("""</style>
    </head>
    <body>
        <div id="mapid"></div>
        <script>
                var mymap = L.map('mapid').setView([51.505, -0.09], 13);
                L.tileLayer('https://api.mapbox.com/styles/v1/"""),format.raw/*22.63*/("""{"""),format.raw/*22.64*/("""id"""),format.raw/*22.66*/("""}"""),format.raw/*22.67*/("""/tiles/"""),format.raw/*22.74*/("""{"""),format.raw/*22.75*/("""z"""),format.raw/*22.76*/("""}"""),format.raw/*22.77*/("""/"""),format.raw/*22.78*/("""{"""),format.raw/*22.79*/("""x"""),format.raw/*22.80*/("""}"""),format.raw/*22.81*/("""/"""),format.raw/*22.82*/("""{"""),format.raw/*22.83*/("""y"""),format.raw/*22.84*/("""}"""),format.raw/*22.85*/("""?access_token="""),format.raw/*22.99*/("""{"""),format.raw/*22.100*/("""accessToken"""),format.raw/*22.111*/("""}"""),format.raw/*22.112*/("""', """),format.raw/*22.115*/("""{"""),format.raw/*22.116*/("""
                    """),format.raw/*23.21*/("""attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
                    maxZoom: 18,
                    id: 'mapbox/streets-v11',
                    accessToken: 'pk.eyJ1IjoiaGl0eWFuYW4iLCJhIjoiY2s2Y205NXJ3MWRyYzNrb2I5cnJnYmZjaCJ9.GCFhUqquhJXTdtSvqAjG8g'
                """),format.raw/*27.17*/("""}"""),format.raw/*27.18*/(""").addTo(mymap);

                //var marker = L.marker([51.5, -0.09]).addTo(mymap);

                """),_display_(/*31.18*/for(p <- message) yield /*31.35*/ {_display_(Seq[Any](format.raw/*31.37*/("""
                    """),format.raw/*32.21*/("""L.circle("""),_display_(/*32.31*/p),format.raw/*32.32*/(""", """),format.raw/*32.34*/("""{"""),format.raw/*32.35*/("""
                        """),format.raw/*33.25*/("""color: 'red',
                        fillColor: '#f03',
                        fillOpacity: 0.5,
                        radius: 500
                    """),format.raw/*37.21*/("""}"""),format.raw/*37.22*/(""").addTo(mymap);
                """)))}),format.raw/*38.18*/("""
               """),format.raw/*39.16*/("""/* var circle = L.circle(, """),format.raw/*39.43*/("""{"""),format.raw/*39.44*/("""
                    """),format.raw/*40.21*/("""color: 'red',
                    fillColor: '#f03',
                    fillOpacity: 0.5,
                    radius: 500
                """),format.raw/*44.17*/("""}"""),format.raw/*44.18*/(""").addTo(mymap);*/

               /* var polygon = L.polygon([
                    [51.509, -0.08],
                    [51.503, -0.06],
                    [51.51, -0.047]
                ]).addTo(mymap);*/
        </script>
    </body>
</html>
"""))
      }
    }
  }

  def render(message:List[JsonNode]): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((List[JsonNode]) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-02-18T16:47:33.743
                  SOURCE: F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/app/views/map.scala.html
                  HASH: cfd0b701a6761db67057781ac2df89f6ac317319
                  MATRIX: 651->1|1008->49|1127->75|1755->677|1784->678|1813->679|1868->706|1897->707|1933->716|2176->931|2205->932|2235->934|2264->935|2299->942|2328->943|2357->944|2386->945|2415->946|2444->947|2473->948|2502->949|2531->950|2560->951|2589->952|2618->953|2660->967|2690->968|2730->979|2760->980|2792->983|2822->984|2871->1005|3352->1458|3381->1459|3512->1563|3545->1580|3585->1582|3634->1603|3671->1613|3693->1614|3723->1616|3752->1617|3805->1642|3988->1797|4017->1798|4081->1831|4125->1847|4180->1874|4209->1875|4258->1896|4425->2035|4454->2036
                  LINES: 24->1|29->2|34->3|46->15|46->15|46->15|46->15|46->15|47->16|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|53->22|54->23|58->27|58->27|62->31|62->31|62->31|63->32|63->32|63->32|63->32|63->32|64->33|68->37|68->37|69->38|70->39|70->39|70->39|71->40|75->44|75->44
                  -- GENERATED --
              */
          