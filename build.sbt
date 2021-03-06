name := "WebSocket2"
 
version := "1.0" 
      
lazy val `websocket2` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"
      
resolvers += "Akka Snapshot Repository" at "https://repo.akka.io/snapshots/"
      
scalaVersion := "2.12.2"

libraryDependencies ++= Seq( jdbc , ehcache , ws , specs2 % Test , guice  )
libraryDependencies += "com.typesafe.play" %% "play-iteratees" % "2.6.1"
libraryDependencies += "com.yahoofinance-api" % "YahooFinanceAPI" % "3.15.0"
unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

      