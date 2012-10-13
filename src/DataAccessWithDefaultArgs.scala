class DataAccessWithDefaultArgs(
 val logger : Logger = new Logger {}
) {

  def query[A](in : String) : A = {
    logger.log("QUERY", in)
    ???
  }
}

class DoubleDataAccess(
  logger : Logger = new Logger {}
) extends DataAccessWithDefaultArgs(logger) {
  //...
}


