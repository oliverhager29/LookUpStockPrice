# Instructions to run:
```
# install latest SBT and JDK13
git clone https://github.com/oliverhager29/LookUpStockPrice
sbt run
# wait for "Server started ..." message
# point browser to http://localhost:9000
```

The following UI is displayed. Your enter a 
stock symbol and then press the "Add" button. 
The stock symbol is added to the list below.

The stock price is requested from the server and
sent back via Web Socket (ws://localhost:9000/socket).
A "loading ..." message indicates that no stock price
has yet arrived. If the symbol is invalid then an 
"unknown stock" is displayed. If the price arrives
from the server then the price is displayed behind
the stock symbol.

Periodically (here every 30 seconds) the server is asked 
to look up stock prices again for all added stock
symbols. The price for an unknown stock symbol 
is also looked up just in case a new stock with that
symbol becomes available. Each stock symbol has a
"Delete" button to delete it from the list. The
for the deleted stock symbol is no longer returned. 

## Screen:
```
Lookup Stock Prices

Enter stock symbol:
XYZ                Add

Stocks:
BABA ($222.37)          Delete
INTC ($62.73)           Delete
xxxxxx (unknown stock)  Delete
```

# Design:
## Server:
A Scala controller StockController reacts to the URL
"/socket" (mapped in conf/routes) opening a 
 web socket connection (ws://localhost:9000/socket). 
 It assigns a socket actor LookUpStockPriceWebSocketActor 
 to it to listen for stock lookup price requests. 
 The price is looked up by using the Yahoo Finance Java API
 and pushes out the prices once received from Yahoo. 
 
 ## Client:
 The file "views/lookUpStockPrice.html" contains the client
 HTML and JavaScript.
 
 An HTML5 Web socket is created every time a new stock symbol
 is added. The stock symbol is send over to the server 
 (ws://localhost:9000/socket). Once a price is received from
 the server the stock symbol in the list is updated via
 DOM modification using the "onmessage" handler. After that 
 the Web socket is closed. In parallel every 30 seconds
 the prices for all added stock symbols are 
 requested from the server. Once a price is received
 the list element with the stock symbol is updated.
 
 The UI uses standard HTML5 and JavaScript to 
 implement the "Add" and "Delete" stock functionality.
 The function "refreshStockList()" renders the stock
 symbol list. the function "handleAdd()" reacts to
 pressing the "Add" button. The stock symbol is
 appended with the stock symbol enter in the input 
 field. Duplicates are ignored. The list is re-sorted
 and re-rendered via function "refreshStockList()".
 The input field is cleared.
 
 For the new stock symbol the price is requested
 by calling "sendToWebSocket()" that creates a new
 Web socket and send over stock symbol. Callback
 functions are registered for detecting when the 
 Web socket is open, so the request can be send over
 to the server. Further a callback is called when 
 a price is returned for some stock symbol 
 (contains symbol and price). And there is a callback
 for receiving errors and when the Web socket is closed.
 Errors are display above the form.
 
 I left console logs to see when the Web socket communication
 takes place (Browser -> Dev Tools -> Console).
 
 
 


