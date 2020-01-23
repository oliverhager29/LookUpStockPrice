
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

object lookUpStockPrice extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<meta charset="utf-8" />
<title>Lookup Stock Prices</title>
<link rel="stylesheet" media="screen" href=""""),_display_(/*4.46*/routes/*4.52*/.Assets.versioned("stylesheets/lookUpStockPrices.css")),format.raw/*4.106*/("""">
<script language="javascript" type="text/javascript">

  var wsUri = "ws://localhost:9000/socket";

  function createOnOpenHandler(webSocket, stock) """),format.raw/*9.50*/("""{"""),format.raw/*9.51*/("""
      """),format.raw/*10.7*/("""return (evt) => """),format.raw/*10.23*/("""{"""),format.raw/*10.24*/("""
          """),format.raw/*11.11*/("""onOpen(webSocket, evt, stock);
      """),format.raw/*12.7*/("""}"""),format.raw/*12.8*/("""
  """),format.raw/*13.3*/("""}"""),format.raw/*13.4*/("""

  """),format.raw/*15.3*/("""function createOnMessageHandler(webSocket) """),format.raw/*15.46*/("""{"""),format.raw/*15.47*/("""
      """),format.raw/*16.7*/("""return (evt) => """),format.raw/*16.23*/("""{"""),format.raw/*16.24*/("""
          """),format.raw/*17.11*/("""onMessage(webSocket, evt);
      """),format.raw/*18.7*/("""}"""),format.raw/*18.8*/("""
  """),format.raw/*19.3*/("""}"""),format.raw/*19.4*/("""

  """),format.raw/*21.3*/("""function sendToWebSocket(stock)
  """),format.raw/*22.3*/("""{"""),format.raw/*22.4*/("""
      """),format.raw/*23.7*/("""const webSocket = new WebSocket(wsUri);
      webSocket.onopen = createOnOpenHandler(webSocket, stock);
      webSocket.onclose = function(evt) """),format.raw/*25.41*/("""{"""),format.raw/*25.42*/(""" """),format.raw/*25.43*/("""onClose(evt) """),format.raw/*25.56*/("""}"""),format.raw/*25.57*/(""";
      webSocket.onmessage = createOnMessageHandler(webSocket);
      webSocket.onerror = function(evt) """),format.raw/*27.41*/("""{"""),format.raw/*27.42*/(""" """),format.raw/*27.43*/("""onError(evt) """),format.raw/*27.56*/("""}"""),format.raw/*27.57*/(""";
  """),format.raw/*28.3*/("""}"""),format.raw/*28.4*/("""

  """),format.raw/*30.3*/("""function onOpen(webSocket, evt, stock)
  """),format.raw/*31.3*/("""{"""),format.raw/*31.4*/("""
      """),format.raw/*32.7*/("""console.log("Web socket opened");
      doSend(webSocket, stock);
  """),format.raw/*34.3*/("""}"""),format.raw/*34.4*/("""

  """),format.raw/*36.3*/("""function onClose(evt)
  """),format.raw/*37.3*/("""{"""),format.raw/*37.4*/("""
      """),format.raw/*38.7*/("""console.log("Web socket closed");
  """),format.raw/*39.3*/("""}"""),format.raw/*39.4*/("""

  """),format.raw/*41.3*/("""function onMessage(webSocket, evt)
  """),format.raw/*42.3*/("""{"""),format.raw/*42.4*/("""
      """),format.raw/*43.7*/("""console.log("Receiving message:"+evt.data);
      const pos = evt.data.indexOf("#");
      if(pos>=0) """),format.raw/*45.18*/("""{"""),format.raw/*45.19*/("""
          """),format.raw/*46.11*/("""const stock = evt.data.substr(0, pos);
          const price = evt.data.substr(pos + 1);
          if(price==="invalid") """),format.raw/*48.33*/("""{"""),format.raw/*48.34*/("""
              """),format.raw/*49.15*/("""const priceStr = "unknown stock";
              document.getElementById("StockPriceFor" + stock).innerText = priceStr;
              priceForStock[stock] = priceStr;
          """),format.raw/*52.11*/("""}"""),format.raw/*52.12*/("""
          """),format.raw/*53.11*/("""else """),format.raw/*53.16*/("""{"""),format.raw/*53.17*/("""
              """),format.raw/*54.15*/("""const priceStr = "$" + price;
              document.getElementById("StockPriceFor" + stock).innerText = priceStr;
              priceForStock[stock] = priceStr;
          """),format.raw/*57.11*/("""}"""),format.raw/*57.12*/("""
      """),format.raw/*58.7*/("""}"""),format.raw/*58.8*/("""
      """),format.raw/*59.7*/("""webSocket.close();
  """),format.raw/*60.3*/("""}"""),format.raw/*60.4*/("""

  """),format.raw/*62.3*/("""function onError(evt)
  """),format.raw/*63.3*/("""{"""),format.raw/*63.4*/("""
      """),format.raw/*64.7*/("""console.log("Receiving error:"+evt.data);
      document.getElementById("ErrorMessage").innerHTML = '<span>Error: ' + evt.data + '</span>';
  """),format.raw/*66.3*/("""}"""),format.raw/*66.4*/("""

  """),format.raw/*68.3*/("""function doSend(webSocket, message)
  """),format.raw/*69.3*/("""{"""),format.raw/*69.4*/("""
      """),format.raw/*70.7*/("""console.log("Sending message:"+message);
      webSocket.send(message);
  """),format.raw/*72.3*/("""}"""),format.raw/*72.4*/("""

  """),format.raw/*74.3*/("""let stocks=[];
  let stockField="";
  let priceForStock="""),format.raw/*76.21*/("""{"""),format.raw/*76.22*/("""}"""),format.raw/*76.23*/(""";
  function handleStockFieldChange() """),format.raw/*77.37*/("""{"""),format.raw/*77.38*/("""
     """),format.raw/*78.6*/("""stockField = document.getElementById("StockField").value;
  """),format.raw/*79.3*/("""}"""),format.raw/*79.4*/("""

  """),format.raw/*81.3*/("""function removeStock(stock) """),format.raw/*81.31*/("""{"""),format.raw/*81.32*/("""
    """),format.raw/*82.5*/("""stocks = stocks.filter(s => s!==stock);
    refreshStockList();
  """),format.raw/*84.3*/("""}"""),format.raw/*84.4*/("""

  """),format.raw/*86.3*/("""function handleAdd() """),format.raw/*86.24*/("""{"""),format.raw/*86.25*/("""
     """),format.raw/*87.6*/("""if(!stocks.find(s => s===stockField)) """),format.raw/*87.44*/("""{"""),format.raw/*87.45*/("""
         """),format.raw/*88.10*/("""stocks.push(stockField);
         refreshStockList();
         sendToWebSocket(stockField);
         document.getElementById("StockField").value = "";
     """),format.raw/*92.6*/("""}"""),format.raw/*92.7*/("""
  """),format.raw/*93.3*/("""}"""),format.raw/*93.4*/("""

  """),format.raw/*95.3*/("""function refreshStockList() """),format.raw/*95.31*/("""{"""),format.raw/*95.32*/("""
      """),format.raw/*96.7*/("""stocks.sort();
      const stocksElement = document.getElementById("stocks");
      let listHtml="<ul>Stocks:";
      stocks.forEach(s => """),format.raw/*99.27*/("""{"""),format.raw/*99.28*/("""
          """),format.raw/*100.11*/("""listHtml+=`<li><span><span class="DataField">$"""),format.raw/*100.57*/("""{"""),format.raw/*100.58*/("""s"""),format.raw/*100.59*/("""}"""),format.raw/*100.60*/("""&nbsp;(<span id="StockPriceFor$"""),format.raw/*100.91*/("""{"""),format.raw/*100.92*/("""s"""),format.raw/*100.93*/("""}"""),format.raw/*100.94*/("""">$"""),format.raw/*100.97*/("""{"""),format.raw/*100.98*/("""priceForStock[s]?priceForStock[s]:"loading ...""""),format.raw/*100.145*/("""}"""),format.raw/*100.146*/("""</span>)</span><span class="DeleteButton"><button type="button" name="delete" value="delete" onClick="removeStock('$"""),format.raw/*100.262*/("""{"""),format.raw/*100.263*/("""s"""),format.raw/*100.264*/("""}"""),format.raw/*100.265*/("""');">Delete</Button></span></span></li>`;
      """),format.raw/*101.7*/("""}"""),format.raw/*101.8*/(""");
      listHtml+="</ul>";
      if(stocks.length===0) """),format.raw/*103.29*/("""{"""),format.raw/*103.30*/("""
          """),format.raw/*104.11*/("""listHtml+='<div>--- None yet added ---</div>';
      """),format.raw/*105.7*/("""}"""),format.raw/*105.8*/("""
      """),format.raw/*106.7*/("""stocksElement.innerHTML = listHtml;
  """),format.raw/*107.3*/("""}"""),format.raw/*107.4*/("""

  """),format.raw/*109.3*/("""setInterval(function()"""),format.raw/*109.25*/("""{"""),format.raw/*109.26*/("""
      """),format.raw/*110.7*/("""stocks.forEach(s => sendToWebSocket(s) );
  """),format.raw/*111.3*/("""}"""),format.raw/*111.4*/(""", 30000);

  window.addEventListener("load", init, false);

  </script>

<div class="Heading">Lookup Stock Prices</div>
<div>
    <div>
        <div class="ErrorMessage" id="errorMessage"></div>
        <form>
            <div class="InputLabel">
                <label>Enter stock symbol:</label>
            </div>
            <div>
                <span class="InputField">
                    <input id="StockField" type="text" minlength="20" maxlength="20" name="stock" value="" onChange="handleStockFieldChange();"/>
                </span>
                <span class="AddButton">
                    <button type="button" name="add" value="add" onClick="handleAdd();">Add</button>
                </span>
            </div>
            <div class="List" id="stocks"><ul>Stocks:</ul><div>--- None yet added ---</div></div>
        </form>
    </div>
</div>
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
                  DATE: 2020-01-22T22:01:58.902637
                  SOURCE: /Users/oliverhager/StockServer/LookUpStockPrice/app/views/lookUpStockPrice.scala.html
                  HASH: 589d006dd8079ee0b8b3c30db875034967a67972
                  MATRIX: 822->0|969->121|983->127|1058->181|1237->333|1265->334|1299->341|1343->357|1372->358|1411->369|1475->406|1503->407|1533->410|1561->411|1592->415|1663->458|1692->459|1726->466|1770->482|1799->483|1838->494|1898->527|1926->528|1956->531|1984->532|2015->536|2076->570|2104->571|2138->578|2310->722|2339->723|2368->724|2409->737|2438->738|2571->843|2600->844|2629->845|2670->858|2699->859|2730->863|2758->864|2789->868|2857->909|2885->910|2919->917|3014->985|3042->986|3073->990|3124->1014|3152->1015|3186->1022|3249->1058|3277->1059|3308->1063|3372->1100|3400->1101|3434->1108|3564->1210|3593->1211|3632->1222|3781->1343|3810->1344|3853->1359|4057->1535|4086->1536|4125->1547|4158->1552|4187->1553|4230->1568|4430->1740|4459->1741|4493->1748|4521->1749|4555->1756|4603->1777|4631->1778|4662->1782|4713->1806|4741->1807|4775->1814|4944->1956|4972->1957|5003->1961|5068->1999|5096->2000|5130->2007|5231->2081|5259->2082|5290->2086|5374->2142|5403->2143|5432->2144|5498->2182|5527->2183|5560->2189|5647->2249|5675->2250|5706->2254|5762->2282|5791->2283|5823->2288|5916->2354|5944->2355|5975->2359|6024->2380|6053->2381|6086->2387|6152->2425|6181->2426|6219->2436|6402->2592|6430->2593|6460->2596|6488->2597|6519->2601|6575->2629|6604->2630|6638->2637|6804->2775|6833->2776|6873->2787|6948->2833|6978->2834|7008->2835|7038->2836|7098->2867|7128->2868|7158->2869|7188->2870|7220->2873|7250->2874|7327->2921|7358->2922|7504->3038|7535->3039|7566->3040|7597->3041|7673->3089|7702->3090|7787->3146|7817->3147|7857->3158|7938->3211|7967->3212|8002->3219|8068->3257|8097->3258|8129->3262|8180->3284|8210->3285|8245->3292|8317->3336|8346->3337
                  LINES: 26->1|29->4|29->4|29->4|34->9|34->9|35->10|35->10|35->10|36->11|37->12|37->12|38->13|38->13|40->15|40->15|40->15|41->16|41->16|41->16|42->17|43->18|43->18|44->19|44->19|46->21|47->22|47->22|48->23|50->25|50->25|50->25|50->25|50->25|52->27|52->27|52->27|52->27|52->27|53->28|53->28|55->30|56->31|56->31|57->32|59->34|59->34|61->36|62->37|62->37|63->38|64->39|64->39|66->41|67->42|67->42|68->43|70->45|70->45|71->46|73->48|73->48|74->49|77->52|77->52|78->53|78->53|78->53|79->54|82->57|82->57|83->58|83->58|84->59|85->60|85->60|87->62|88->63|88->63|89->64|91->66|91->66|93->68|94->69|94->69|95->70|97->72|97->72|99->74|101->76|101->76|101->76|102->77|102->77|103->78|104->79|104->79|106->81|106->81|106->81|107->82|109->84|109->84|111->86|111->86|111->86|112->87|112->87|112->87|113->88|117->92|117->92|118->93|118->93|120->95|120->95|120->95|121->96|124->99|124->99|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|125->100|126->101|126->101|128->103|128->103|129->104|130->105|130->105|131->106|132->107|132->107|134->109|134->109|134->109|135->110|136->111|136->111
                  -- GENERATED --
              */
          