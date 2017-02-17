package services.newsstand

import io.gatling.core.Predef._
import io.gatling.http.Predef._

/**
  * Created by tuananh on 8/17/16.
  */
object AYCEEntitlement {
  val get = group("Polling AE") {
    tryMax(20) {
      exec(http("Polling AYCE Entitlement")
        .get("/entitlement/v1//users/${user_id}/ayce_entitlements?project_id=${project_id}&status=${status}")
        //            .body(Nil).asJSON.check(jsonPath("$.data").find(1).build)
        //          .check(jsonPath("$.data").find(1).build)
        .asJSON.check(jsonPath("$.data[0].id").find.build)

        //        .check(status.is(session => 200 + ThreadLocalRandom.current.nextInt(10))) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
        //        .check(status.is(201)) // we do a check on a condition that's been customized with a lambda. It will be evaluated every time a user executes the request
      ).pause(1)
    }
  }
}

