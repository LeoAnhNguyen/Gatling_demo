package services.users

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 9/15/16.
  */
object MigratingUserfromLegacy {

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


  //2. Create User Preference
  val createUserPreference =
    exec(http("Create User Preference")
      .post("/identity/v1/preferences")
      .body(StringBody(
        """
          |{
          |   "user_id": "${user_id}",
          |   "project_id": 1,
          |   "default_newsstand_id": 1,
          |   "default_locale_code": "string",
          |   "default_currency_code": "usd",
          |   "default_max_content_rating": 0,
          |   "allow_adult_content": true,
          |   "opt_out_all": true,
          |   "opt_out_delivery_notifications": true,
          |   "opt_out_third_party": true,
          |   "opt_out_marketing": true,
          |   "preferred_email_format": "abc",
          |   "email_status": true,
          |   "created_by": 0,
          |   "status": 0
          |}
        """.stripMargin)).asJSON)
      .pause(1)

  //3. Create User Registration
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

  //4. Update User Selection
  val updateUserSelections =
    exec(http("update User Selections")
      .put("/identity/v1/users/${user_id}/selections")
      .body(StringBody(
        """
          |[{
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 104,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 119,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 108,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 124,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 113,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 111,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 103,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 117,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 110,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 125,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 118,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 106,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 120,
          |  "legacy_identifier": "3345702584#3"
          |}, {
          |  "created_by": 4,
          |  "object_type": 4,
          |  "project_id": ${project_id},
          |  "status": 1,
          |  "type": 1,
          |  "object_id": 107,
          |  "legacy_identifier": "3345702584#3"
          |}]
        """.stripMargin)).asJSON)
      .pause(1)

}

