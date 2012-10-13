trait Logger {
  def log(category: String, msg: String) {
    println(msg)
  }
}

trait RemoteLogger extends Logger {
  val socket = ???
  override def log(category: String, msg: String) {
    //Send over socket
  }
}

trait NullLogger extends Logger {
  override def log(category: String, msg: String) {}
}

trait HasLogger {
  val logger: Logger = new Logger {}
}

trait HasRemoteLogger extends HasLogger {
  override val logger: Logger = new RemoteLogger {}
}

trait HasNullLogger extends HasLogger {
  override val logger: Logger = new NullLogger {}
}

trait DataAccess extends HasLogger {
  def query[A](in: String): A = {
    logger.log("QUERY", in)
    ???
  }
}

object DataAccessTest extends {
  val service = new DataAccess with HasNullLogger
  //work with service
}

