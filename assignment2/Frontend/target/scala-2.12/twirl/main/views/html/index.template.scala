
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>
<html>
    <header class="topbar">
       """),format.raw/*10.43*/("""
    """),format.raw/*11.5*/("""</header>
    <body>
        #1.1 Given author name A, list all of her co-authors.
        <form action=""""),_display_(/*14.24*/routes/*14.30*/.PubController.coAuthor()),format.raw/*14.55*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="username">author</label>
                            <input id="author" name="author" type="text" class="validate">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
        ----------------------------------------------------------------------<br/>
        #1.2 Given a paper name (i.e., title), list its publication metadata.
        <form action=""""),_display_(/*31.24*/routes/*31.30*/.PubController.pubbytitle()),format.raw/*31.57*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="title">title</label>
                            <input id="title" name="title" type="text" class="validate" width="40%">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>

        ----------------------------------------------------------------------<br/>
        #1.3 Given a journal name and a year (volume) and an issue (number),<br/>
        #find out the metadata of all the papers published in the book
        <form action=""""),_display_(/*50.24*/routes/*50.30*/.PubController.pubbyyear()),format.raw/*50.56*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="journal">journal</label>
                            <input id="journal" name="journal" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="volume">volume</label>
                            <input id="volume" name="volume" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="number">number</label>
                            <input id="number" name="number" type="text" class="validate" width="40%">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>

        ----------------------------------------------------------------------<br/>
        #1.4 Display all the article titles published in the area of SOC;<br/>
        <form action=""""),_display_(/*76.24*/routes/*76.30*/.PubController.alltitle()),format.raw/*76.55*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li><label for="journal">Click submit below, donot need input.</label></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>

        ----------------------------------------------------------------------<br/>
        #1.5 Display the titles of the articles published by a researcher in a specific year;<br/>
        <form action=""""),_display_(/*91.24*/routes/*91.30*/.PubController.pubbyresearchyear()),format.raw/*91.64*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="researcher">researcher</label>
                            <input id="researcher" name="researcher" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="year">year&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <input id="year" name="year" type="text" class="validate" width="40%">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
        ----------------------------------------------------------------------<br/>
        #1.6 Display all the authors who have published more than 10 papers in the area of SOC to date<br/>
        <form action=""""),_display_(/*112.24*/routes/*112.30*/.PubController.greatAuthors()),format.raw/*112.59*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul><li><label for="researcher">Click Submit, no need input</label></li></ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
        ----------------------------------------------------------------------<br/>
        #2.1 Given a researcher's name and a year, list all published papers' metadata;<br/>
        <form action=""""),_display_(/*124.24*/routes/*124.30*/.PubController.pubByResearcherAndYear()),format.raw/*124.69*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="researcher">researcher</label>
                            <input id="researcher" name="researcher" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="year">year</label>
                            <input id="year" name="year" type="text" class="validate" width="40%">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
        ----------------------------------------------------------------------<br/>
        #2.2  For the productive authors (e.g., published more than 10 papers)<br/>
        ##in the area of SOC, list all of their co-authors;<br/>
        # get All productive author's coauthors;<br/>
        <form action=""""),_display_(/*147.24*/routes/*147.30*/.PubController.greatCoAuthors()),format.raw/*147.61*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li><label for="researcher">Click submit, no input needed.</label></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
        ----------------------------------------------------------------------<br/>
            #2.3 Given a conference name, and a range of years (between 2003-2019), mark the locations of where the conference was held in a map.
        <form action=""""),_display_(/*161.24*/routes/*161.30*/.PubController.altLot()),format.raw/*161.53*/("""" method="GET">
            <div class="row">
                <div class="input-field col s12">
                    <ul>
                        <li>
                            <label for="conferencename">conference name</label>
                            <input id="conferencename" name="conferencename" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="startyear">start year</label>
                            <input id="startyear" name="startyear" type="text" class="validate" width="40%">
                        </li>
                        <li>
                            <label for="endyear">end year</label>
                            <input id="endyear" name="endyear" type="text" class="validate" width="40%">
                        </li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <button id="api-search-button" class="btn col s4 offset-s4" type="submit">Submit</button>
            </div>
        </form>
    </body>
</html>
"""))
      }
    }
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-02-18T16:38:01.712
                  SOURCE: F:/Documents/a-cmu/18655 SOC/Lab-4-Ebean/Lab-4-Ebean/Frontend/app/views/index.scala.html
                  HASH: 48db9af13ffce5b600a9836d69f33f75f14e7374
                  MATRIX: 948->1|1059->19|1145->303|1177->308|1310->414|1325->420|1371->445|2158->1205|2173->1211|2221->1238|3090->2080|3105->2086|3152->2112|4405->3338|4420->3344|4466->3369|5160->4036|5175->4042|5230->4076|6315->5133|6331->5139|6382->5168|7017->5775|7033->5781|7094->5820|8250->6948|8266->6954|8319->6985|9056->7694|9072->7700|9117->7723
                  LINES: 28->1|33->2|36->10|37->11|40->14|40->14|40->14|57->31|57->31|57->31|76->50|76->50|76->50|102->76|102->76|102->76|117->91|117->91|117->91|138->112|138->112|138->112|150->124|150->124|150->124|173->147|173->147|173->147|187->161|187->161|187->161
                  -- GENERATED --
              */
          