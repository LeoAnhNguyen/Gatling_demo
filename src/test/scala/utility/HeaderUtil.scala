package utility

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 8/17/16.
  */
object HeaderUtil {
  def httpProtocol = http
     //   .baseURL("http://sync-api.ziniopro.com")
    //.baseURL("http://stg-api.ziniopro.com")
    //    .inferHtmlResources(BlackList("*\\.css", "*.js", "*.ico"))
     // .baseURL("http://ziniopro.vn.audiencemedia.com")
    //.baseURL("ziniopro.zenith.int")
    .baseURL("http://loadtest-api.ziniopro.com")
    .contentTypeHeader("application/json")
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, sdch")
//    .acceptLanguageHeader("en-US,en;q=0.8")
//    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
//    .disableResponseChunksDiscarding
    .disableCaching

  //  val random = new util.Random
  //  //  val feeder = Iterator.continually(Map("user_id" -> (300049 + random.nextInt(2).toString), "time" -> System.currentTimeMillis().toString))
  //  val pattern = "yyyymmdd"
  //
  //  val format = DateTimeFormatter.ofPattern(pattern)
  //  val today = format.format(LocalDateTime.now())
}