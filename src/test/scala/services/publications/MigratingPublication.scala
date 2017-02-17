package services.publications

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/19/16.
  */
object MigratingPublication {

  //1. Create Publisher
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
        """.stripMargin))
      .check(status.is(201))
      .check(regex(""""id":"(\d+)"""").saveAs("publisher_id"))
      .check(bodyString.saveAs("body")))
      .pause(5)
      .exec(session => {
        session
      })

  //2. create Publication
  val  createPublication =
    exec(http("Create Publication")
      .post("/catalog/v1/publications")
      .body(StringBody(
        """
          |{
          |   "name": "Lynx Publication",
          |   "frequency": "monthly",
          |   "internal_name": "Publication LL",
          |   "description": "Publication LL",
          |   "country_code": "US",
          |   "language_code": "en",
          |   "locale_code": "eng-US",
          |   "publisher_id": "${publisher_id}",
          |   "content_rating": "15",
          |   "remote_identifier": "LynxLL${random}",
          |   "created_by": 10,
          |   "site_id": 10,
          |   "status": 1,
          |   "type": 1,
          |   "no_of_issues": 1,
          |   "allow_xml": 0,
          |   "allow_pdf": 0,
          |   "logo": "string",
          |   "legacy_identifier": ""
          |}
        """.stripMargin)).asJSON)
      .pause(5)

}
