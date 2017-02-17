package utility

/**
  * Created by tuananh on 8/17/16.
  */
object FeederUtl {

  def feeder = Iterator.continually(Map(
    "user_id_random" -> System.currentTimeMillis().toString,
    "random" -> System.currentTimeMillis().toString,
    "newsstand_id" -> System.currentTimeMillis().toString,
    "project_id" -> 1003,
    "status" -> 1,
    "issue_id" -> 0,
    "device_id" -> 0


  ))

}
