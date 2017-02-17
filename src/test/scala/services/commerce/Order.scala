package services.commerce

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 8/17/16.
  */
object Order {

  //Create Order for Load Test
  val createlt =
    exec(http("Create Order Load Test")
      .post("/commerce/v1/orders")
      .body(StringBody(
        """
          |{
          |  "type": 1,
          |  "offer_ids": 1,
          |  "source_application_id": "${random}",
          |  "source_project_id": 1003,
          |  "payment_handler": "load_test",
          |  "user_id": "${user_id}",
          |  "device_id": 1,
          |  "source_type": 1,
          |  "country_code": "VN",
          |  "receipt_data": "string",
          |  "currency_code": "VND",
          |  "transaction_id": "string",
          |  "total": 0,
          |  "remote_identifier": "LynxLL${random}",
          |  "transacted_date": "2016-08-23 10:00:00",
          |  "created_by": 1
          |}
        """.stripMargin)).asJSON)
      .pause(5)

  //Create Order for Relay
  val createrl =
    exec(http("Create Order Relay")
      .post("/commerce/v1/orders")
      .body(StringBody(
        """
          |{
          |  "type": 1,
          |  "offer_ids": 1,
          |  "source_application_id": "${random}",
          |  "source_project_id": 0,
          |  "payment_handler": "relay_webservice",
          |  "user_id": "${user_id}",
          |  "device_id": 1,
          |  "source_type": 1,
          |  "country_code": "VN",
          |  "receipt_data": "string",
          |  "currency_code": "VND",
          |  "transaction_id": "string",
          |  "total": 0,
          |  "remote_identifier": "LynxLL${random}",
          |  "transacted_date": "2016-04-04 10:00:00",
          |  "created_by": 1
          |}
        """.stripMargin)).asJSON)
      .pause(5)

  //Create Order for SamSung
  val createss =
    exec(http("Create Order Samsung")
      .post("/commerce/v1/orders")
      .body(StringBody(
        """
          |{
          |
          |        "user_id": "${random}",
          |        "device_id": 1234567,
          |        "offer_ids": 1,
          |        "type": 1,
          |        "source_application_id": 1,
          |        "source_project_id": 1,
          |        "payment_handler": "samsungpay",
          |        "source_type": 1,
          |        "transacted_date": "2016-04-04 10:00:00",
          |        "country_code": "US",
          |        "created_by": 1,
          |        "transaction_data": "eyJhbGciOiJSU0ExXzUiLCJraWQiOiJuV3lIL1V."
          |
          |}
        """.stripMargin)).asJSON)
      .pause(5)

  //Create Order for Apple
  val createap =
    exec(http("Create Order ")
      .post("/commerce/v1/orders")
      .body(StringBody(
        """
          |{
          |
          |        "user_id" : "${random}",
          |        "device_id": 123,
          |        "offer_ids" : 1,
          |        "source_type" : 1,
          |        "source_application_id" : 1,
          |        "payment_handler" : "itc",
          |        "type": 1,
          |        "receipt_data": "MIInPwYJKo",
          |        "country_code" : "VN",
          |        "transaction_id" : "1000000165332051",
          |        "transacted_date": "2015-07-23T00:00:00Z",
          |        "created_by": 1
          |
          |}
        """.stripMargin)).asJSON)
      .pause(1)

  //Create Order for BrainTree
  /*val createbt =
  //Create User Payment Profile BrainTree
    exec(http("Create User Payment Profile BrainTree")
      .post("/commerce/v1/userpaymentprofiles")
      .body(StringBody(
        """
          |{
          |    "user_id" : "${random}",
          |    "project_id": 1,
          |    "payment_method_nonce": "fake-valid-nonce",
          |    "email": "lynx${random}@zinio.com",
          |    "first_name": "Lynx",
          |    "last_name" : "LL",
          |    "payment_handler": "braintree",
          |    "is_default": "true"
          |}
        """.stripMargin
      )).asJSON)
      .pause(1)

    //Create Order BrainTree
    exec(http("Create Order BrainTree")
      .post("/commerce/v1/orders")
      .body(StringBody(
        """
          |{
          |        "user_id" : "${random}",
          |        "device_id": 0,
          |        "offer_ids" : 1,
          |        "source_type" : 4,
          |        "source_application_id" : 1,
          |        "source_project_id" : 1,
          |        "payment_handler" : "braintree",
          |        "type": 1,
          |        "country_code" : "US",
          |        "transacted_date": "2015-11-05T13:15:30Z"
          |     }
        """.stripMargin
      )).asJSON)
      .pause(1)*/
}