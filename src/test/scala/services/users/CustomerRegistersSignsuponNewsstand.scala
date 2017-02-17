package services.users

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/21/16.
  */
object CustomerRegistersSignsuponNewsstand {

  //1. Create User
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
      .check(status.is(201))
      .check(regex(""""id":(\d+)""").saveAs("user_id"))
      .check(bodyString.saveAs("body")))
      .pause(1)
      .exec(session => {
        session
      })


  //2. Create User Registration
  val createUserRegistration =
    exec(http("Create User Registration")
      .post("/identity/v1/registrations")
      .body(StringBody(
        """
          |{
          |   "user_id": "${user_id}",
          |   "email": "",
          |   "project_id": "1",
          |   "application_id": "1",
          |   "newsstand_id": "1",
          |   "platform_id": 0,
          |   "device_id": "1",
          |   "source_account_id": "1",
          |   "reference_id": 0,
          |   "legacy_identifier": "lynx${random}",
          |   "created_by": 0,
          |   "status": 0
          |}
        """.stripMargin)).asJSON)
      .pause(1)

}
