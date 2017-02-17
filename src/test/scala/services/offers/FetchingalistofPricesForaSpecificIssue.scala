package services.offers

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/28/16.
  */
object FetchingalistofPricesForaSpecificIssue {

  //Create Prices
  val createSingleIssuePrices =
    exec(http("Create Single Issue Prices")
      .post("/commerce/v1/publications/{publicationId}/single_issue_prices")
      .body(StringBody(
        """
          |{
          |  "project_id": 1,
          |  "newsstand_id": 3051,
          |  "country_code": "US",
          |  "price": 1,
          |  "currency_code": "USD",
          |  "tier": "",
          |  "issue_type": 0,
          |  "created_by":1
          |}
        """.stripMargin))
      .check(regex(""""id":(\d+)""").saveAs("user_id"))
      .check(bodyString.saveAs("body")))
      .pause(1)
      .exec(session => {
        session
      })

  // Get Prices
  val getPrices = group("Get Prices") {

    tryMax(20) {
      exec(http("Polling Newsstand")
        .get("/commerce/v1/publications/${publication_id}/prices")
        //            .body(Nil).asJSON.check(jsonPath("$.data").find(1).build)
        //          .check(jsonPath("$.data").find(1).build)
        .asJSON.check(jsonPath("$.data[0].id").find.build)

        //        .check(status.is(session => 200 + ThreadLocalRandom.current.nextInt(10))) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
        //        .check(status.is(201)) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
      ).pause(1)
    }
  }

}
