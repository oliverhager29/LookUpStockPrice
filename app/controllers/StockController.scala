package controllers;

import play.api.mvc._
import play.api.libs.streams.ActorFlow
import javax.inject.Inject
import akka.actor.ActorSystem
import akka.stream.Materializer

class StockController @Inject() (cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer)
  extends AbstractController(cc) {
  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      LookUpStockPriceWebSocketActor.props(out)
    }
  }
}

import akka.actor._
import yahoofinance._

object LookUpStockPriceWebSocketActor {
  def props(out: ActorRef) = Props(new LookUpStockPriceWebSocketActor(out))
}

class LookUpStockPriceWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case sym: String => {
      val stock = YahooFinance.get(sym)
      if(stock==null) {
        out ! sym + "#invalid"
      }
      else {
        val price = stock.getQuote.getPrice
        out ! (sym + "#" + price)
      }
    }
  }
}