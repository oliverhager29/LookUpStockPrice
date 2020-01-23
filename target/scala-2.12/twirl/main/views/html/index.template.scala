
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
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /*
 * Call the `main` template with two arguments. The first
 * argument is a `String` with the title of the page, the second
 * argument is an `Html` object containing the body of the page.
 */
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*11.2*/main("Look Up Stock Prices")/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""

    """),format.raw/*15.8*/("""
    """),_display_(/*16.6*/lookUpStockPrice()),format.raw/*16.24*/("""

""")))}),format.raw/*18.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-01-22T20:34:57.359992
                  SOURCE: /Users/oliverhager/StockServer/WebSocket2/app/views/index.scala.html
                  HASH: 0f072bf0cc4e292e22ad3f85c8f10d7bab05bbed
                  MATRIX: 1002->291|1039->319|1079->321|1112->365|1144->371|1183->389|1216->392
                  LINES: 30->11|30->11|30->11|32->15|33->16|33->16|35->18
                  -- GENERATED --
              */
          