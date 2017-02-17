package testsuite


import io.gatling.app.Gatling
import io.gatling.core.Predef._
import io.gatling.core.config.GatlingPropertiesBuilder

import scala.concurrent.duration._

class TestRun extends Simulation {

  //Header Config
  val httpProtocol = utility.HeaderUtil.httpProtocol

  //Set Scenario
  //User
  val scn01 = scenarios.LTScenarios.scn01
  val scn06 = scenarios.LTScenarios.scn06
  val scn07 = scenarios.LTScenarios.scn07

  //Publisher
  val scn02 = scenarios.LTScenarios.scn02

  //Publication
  val scn03 = scenarios.LTScenarios.scn03

  //Entitlement
  val scn04 = scenarios.LTScenarios.scn04

  //Order
  val scn05 = scenarios.LTScenarios.scn05


  //Issues
  val scn08 = scenarios.LTScenarios.scn08

  //Subscriptions
  val scn09 = scenarios.LTScenarios.scn09

  //Offfers
  val scn10 = scenarios.LTScenarios.scn10


  //Test Run Config
  val ccu = 2
  val duration = 20

  setUp(scn10.inject(constantUsersPerSec(ccu) during (duration seconds))).protocols(httpProtocol)
  //setUp(scn10.inject(rampUsers(ccu) over(duration minutes))).protocols(httpProtocol)
  //setUp(scn01.inject(atOnceUsers(ccu))).protocols(httpProtocol)
}

object TestRun {
  def main(args: Array[String]) {
2
    // This sets the class for the simulation we want to run.
    val simClass = classOf[TestRun].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)
    Gatling.fromMap(props.build)
  }
}