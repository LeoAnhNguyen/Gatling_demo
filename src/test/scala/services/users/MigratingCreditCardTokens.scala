package services.users

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/21/16.
  */
object MigratingCreditCardTokens {

  val createUPP =
    exec(http("Create User Payment Profiles")
      .post("/commerce/v1/userpaymentprofiles")
      .body(StringBody(
        """
          |{
          |"user_id" : ${random},
          |"project_id": 1,
          |"remote_identifier": "213Bac",
          |"remote_token": "213Bac123",
          |"email": "ngan.huynh@audiencemedia.com",
          |"first_name": "Ngan",
          |"last_name" : "Huynh",
          |"address": "test",
          |"city": "test",
          |"postal_code": "84",
          |"country_code": "VN",
          |"province_code": "",
          |"payment_handler": "braintree"
          |}
        """.stripMargin)).asJSON)
      .pause(1)

}