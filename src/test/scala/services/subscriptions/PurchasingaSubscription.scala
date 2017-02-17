package services.subscriptions

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/22/16.
  */
object PurchasingaSubscription {

  //3. Post a User
  val createUser =
    exec(http("Create User")
      .post("/identity/v1/users")
      .body(StringBody(
        """
          |{
          |   "email": "${random}@zinio.com",
          |   "directory_id": 1,
          |   "password": "aaa",
          |   "first_name": "bbb",
          |   "last_name": "aaa",
          |   "created_by": null,
          |   "registration_status": 1,
          |   "created_by_type": 1,
          |   "country_code": "vn",
          |   "internal_notes": "string",
          |   "access_token": null,
          |   "refresh_token": null,
          |   "expiration_date_token": null
          |}
        """.stripMargin))
      .check(regex(""""id":(\d+)""").saveAs("user_id"))
      .check(bodyString.saveAs("body")))
      .pause(5)
      .exec(session => {
        session
      })

  //1. Create Order
  val createOrder =
    exec(http("Create Order")
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
        """.stripMargin))
      //.check(regex(""""id":"(\d+)"""").saveAs("order_id"))
      //.check(regex(""""source_project_id":"(\d+)"""").saveAs("project_id"))
      .check(bodyString.saveAs("body")))
      .pause(5)
      .exec(session => {
        session
      })

  //Get Entitlement
  val getEntitlement=
    exec(http("get Entitlement")
      .get("/entitlement/v1/users/${user_id}/issue_entitlements?project_id=${project_id}"))
      .pause(5)

}
