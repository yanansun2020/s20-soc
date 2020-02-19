
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
/*1.2*/import model.Publication

object pub extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Publication],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(message: List[Publication]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title></title>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

            <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="docs/images/favicon.ico" />
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin=""/>
        <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
    </head>
    <body>
        <header class="topbar">
            <h1 class="focused" style="font-size: 37px;
                color: #57a957">
                <strong>The result is:</strong>
            </h1>
        </header>
        <div class="row">
            <div class="card col large4 offset-s4 ">
            <ul>
            """),_display_(/*29.14*/for(p <- message) yield /*29.31*/ {_display_(Seq[Any](format.raw/*29.33*/("""
                """),format.raw/*30.17*/("""<li> title: """),_display_(/*30.30*/p/*30.31*/.title),format.raw/*30.37*/("""</li>
                <li>channel: """),_display_(/*31.31*/p/*31.32*/.channel),format.raw/*31.40*/("""</li>
                <li>year: """),_display_(/*32.28*/p/*32.29*/.year),format.raw/*32.34*/("""</li>
                <li>pages: """),_display_(/*33.29*/p/*33.30*/.pages),format.raw/*33.36*/("""</li>
                <li>crossRef: """),_display_(/*34.32*/p/*34.33*/.crossRef),format.raw/*34.42*/("""</li>
                <li>ee: """),_display_(/*35.26*/p/*35.27*/.ee),format.raw/*35.30*/("""</li>
                <li>url: """),_display_(/*36.27*/p/*36.28*/.url),format.raw/*36.32*/("""</li>
                <li>bookTitle: """),_display_(/*37.33*/p/*37.34*/.bookTitle),format.raw/*37.44*/("""</li>
                <li>isbn: """),_display_(/*38.28*/p/*38.29*/.isbn),format.raw/*38.34*/("""</li>
                <li>volume: """),_display_(/*39.30*/p/*39.31*/.volume),format.raw/*39.38*/("""</li>
                <li>number: """),_display_(/*40.30*/p/*40.31*/.number),format.raw/*40.38*/("""</li>
                <li>journal: """),_display_(/*41.31*/p/*41.32*/.journal),format.raw/*41.40*/("""</li>
                <li>series: """),_display_(/*42.30*/p/*42.31*/.series),format.raw/*42.38*/("""</li>
                <li>mdate: """),_display_(/*43.29*/p/*43.30*/.mdate),format.raw/*43.36*/("""</li>
                <li>keyWord: """),_display_(/*44.31*/p/*44.32*/.keyWord),format.raw/*44.40*/("""</li>
                <li>================================</li>
            """)))}),format.raw/*46.14*/("""
            """),format.raw/*47.13*/("""</ul>
            </div>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(message:List[Publication]): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((List[Publication]) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-02-18T15:12:25.273
                  SOURCE: F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/app/views/pub.scala.html
                  HASH: ae4a0e0ca20e0bef99abb3946b0f25d332426d2c
                  MATRIX: 651->1|989->27|1111->56|2638->1558|2671->1575|2711->1577|2756->1594|2796->1607|2806->1608|2833->1614|2896->1650|2906->1651|2935->1659|2995->1692|3005->1693|3031->1698|3092->1732|3102->1733|3129->1739|3193->1776|3203->1777|3233->1786|3291->1817|3301->1818|3325->1821|3384->1853|3394->1854|3419->1858|3484->1896|3494->1897|3525->1907|3585->1940|3595->1941|3621->1946|3683->1981|3693->1982|3721->1989|3783->2024|3793->2025|3821->2032|3884->2068|3894->2069|3923->2077|3985->2112|3995->2113|4023->2120|4084->2154|4094->2155|4121->2161|4184->2197|4194->2198|4223->2206|4331->2283|4372->2296
                  LINES: 24->1|29->2|34->3|60->29|60->29|60->29|61->30|61->30|61->30|61->30|62->31|62->31|62->31|63->32|63->32|63->32|64->33|64->33|64->33|65->34|65->34|65->34|66->35|66->35|66->35|67->36|67->36|67->36|68->37|68->37|68->37|69->38|69->38|69->38|70->39|70->39|70->39|71->40|71->40|71->40|72->41|72->41|72->41|73->42|73->42|73->42|74->43|74->43|74->43|75->44|75->44|75->44|77->46|78->47
                  -- GENERATED --
              */
          