// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/oliverhager/StockServer/LookUpStockPrice/conf/routes
// @DATE:Wed Jan 22 21:00:41 EST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
