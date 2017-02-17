package utility

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import testsuite.TestRun

/**
  * Created by ducnguyen on 8/17/16.
  */
object GatlingRunner {
  def main(args: Array[String]) {

//    val config = PuppetGatlingConfig.initialize()

    // This sets the class for the simulation we want to run.
    val simClass = classOf[TestRun].getName

    val props = new GatlingPropertiesBuilder
//    props.sourcesDirectory("./src/main/scala")
//    props.binariesDirectory("./target/scala-2.11/classes")
    props.simulationClass(simClass)
//    props.runDescription(config.runDescription)
//    props.outputDirectoryBaseName(config.simulationId)
    Gatling.fromMap(props.build)

  }
}
