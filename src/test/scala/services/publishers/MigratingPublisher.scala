package services.publishers

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/19/16.
  */
object MigratingPublisher {
//1. Create Account
  val  createAccount =
    exec(http("Create Account")
      .post("/console/v1/accounts")
      .body(StringBody(
        """
          |{
          |   "type": "1",
          |   "name": "Lynx Test Name",
          |   "description": "Lynx Test Desc.",
          |   "logo": "",
          |   "code": "LynxLL${random}",
          |   "legacy_identifier": "LynxLL${random}",
          |   "payable_code": "${random}",
          |   "receivable_code": "${random}",
          |   "tier": "1",
          |   "country_code": "US",
          |   "website": "www.abc.com",
          |   "related_resource_id": 0,
          |   "created_by": 0,
          |   "status": 1
          |}
        """.stripMargin)).asJSON)
      .pause(1)

  //2. Create Publisher
  val  createPublisher =
    exec(http("Create Publisher")
      .post("/catalog/v1/publishers")
      .body(StringBody(
        """
          |{
          |  "name": "Lynx",
          |  "country_code": "US",
          |  "internal_name": "",
          |  "description": "LynxLL",
          |  "internal_notes": "",
          |  "logo": "",
          |  "remote_identifier": "",
          |  "legacy_identifier": "",
          |  "code": "${random}",
          |  "status": 1
          |}
        """.stripMargin)).asJSON)
      .pause(1)

}
