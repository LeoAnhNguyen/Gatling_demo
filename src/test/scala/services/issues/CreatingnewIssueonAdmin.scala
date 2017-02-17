package services.issues

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/21/16.
  */
object CreatingnewIssueonAdmin {


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
      .pause(1)
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
        """.stripMargin))
      .check(status.is(201))
      .check(regex(""""id":(\d+)""").saveAs("publication_id"))
      .check(bodyString.saveAs("body")))
      .pause(5)
      .exec(session => {
        session
      })

  //3. Post a Issue
  val createIssue =
    exec(http("Create Issue")
      .post("/catalog/v1/issues")
      .body(StringBody(
        """
          |{
          |  "publication_id": "${publication_id}",
          |  "name": "Lynx ${random}",
          |  "internal_name": "LynxLL ${random}",
          |  "issn": "string",
          |  "slug": "string",
          |  "code": "${random}",
          |  "sequence_no": "string",
          |  "description": "string",
          |  "cover_image": "string",
          |  "remote_identifier": 0,
          |  "legacy_issue_id": 0,
          |  "status": 0,
          |  "created_by": 1,
          |  "file_path": "string",
          |  "type": 0,
          |  "legacy_identifier": "string",
          |  "preview": 0,
          |  "has_xml": 0,
          |  "has_pdf": 0,
          |  "binding": 0,
          |  "fulfilment_code": "string",
          |  "allow_printing": 0,
          |  "watermark": 0,
          |  "cover_price": 0,
          |  "cover_currency": "USD",
          |  "no_of_pages": 0
          |}
        """.stripMargin)).asJSON)
      .pause(5)


}
