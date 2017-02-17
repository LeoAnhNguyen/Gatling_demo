package services.entitlements

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/15/16.
  */
object ViaSubscriptionProcessing {

  //1. Get a Subcription
  val getSubscription =
    exec(http("Ger a Subscription")
        .get("")
    )

  //2. Post a delivery
  val createDeliveries =
    exec(http("Create Deliveries")
      .post("/commerce/v1//deliveries")
      .body(StringBody(
        """
          |{
          |  "order_id": 5,
          |  "orderitem_id": 1,
          |  "order_item_type": 1,
          |  "customer_type": 1,
          |  "customer_id": 1,
          |  "object_type": 1,
          |  "object_id": 1,
          |  "product_code": "com.audiencemedia.app135.3months",
          |  "label_type": 1,
          |  "entitlement_id": 1,
          |  "status": 1
          |}
        """.stripMargin)).asJSON)
      .pause(1)

  //3. Post a entitlement
  val createEntitlement=
    exec(http("Create Entitlement")
      .post("/entitlement/v1/issue_entitlements")
      .body(StringBody(
        """
          |{
          |  "user_id": 10,
          |  "device_id": 0,
          |  "publication_id": 1,
          |  "project_id": 1,
          |  "legacy_identifier": "",
          |  "issue_id": 1,
          |  "type": 1,
          |  "status": 1
          |}
        """.stripMargin)).asJSON)
      .pause(1)

}
