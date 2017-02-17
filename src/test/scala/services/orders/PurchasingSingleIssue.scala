package services.orders

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/15/16.
  */
object PurchasingSingleIssue {

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
      .pause(1)
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
      .check(regex(""""id":(\d+)""").saveAs("order_id"))
      .check(bodyString.saveAs("body")))
      .pause(1)
      .exec(session => {
        session
      })

//  //4. Post a delivery
//  val createDeliveries =
//    exec(http("Create Deliveries")
//      .post("/commerce/v1//deliveries")
//      .body(StringBody(
//        """
//          |{
//          |  "order_id": "${order_id}",
//          |  "orderitem_id": 1,
//          |  "order_item_type": 1,
//          |  "customer_type": 1,
//          |  "customer_id": 1,
//          |  "object_type": 1,
//          |  "object_id": 1,
//          |  "product_code": "com.audiencemedia.app135.3months",
//          |  "label_type": 1,
//          |  "entitlement_id": 1,
//          |  "status": 1
//          |}
//        """.stripMargin)).asJSON)
//      .pause(1)

//  //5. Post a entitlement
//  val createEntitlement=
//    exec(http("Create Entitlement")
//      .post("/entitlement/v1/issue_entitlements")
//      .body(StringBody(
//        """
//          |{
//          |  "user_id": "${user_id}",
//          |  "device_id": 0,
//          |  "publication_id": 1,
//          |  "project_id": 1,
//          |  "legacy_identifier": "",
//          |  "issue_id": 1,
//          |  "type": 1,
//          |  "status": 1
//          |}
//        """.stripMargin)).asJSON)
//      .pause(1)

  val getEntitlement=
    exec(http("get Entitlement")
      .get("/entitlement/v1/users/${user_id}/issue_entitlements?project_id=${project_id}"))
    .pause(1)
}
