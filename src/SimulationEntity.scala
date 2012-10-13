trait SimulationEntity {
  def handleMessage(msg: SimulationMessage,
                    ctx: SimulationContext)
}

trait MixableEntity {
  def handleMessage(msg: SimulationMessage,
                    ctx: SimulationContext) {}

}

trait NetworkEntity extends MixableEntity {
  def getMacAddress(ip: String) : String
  def hasIpAddress(addr: String) : Boolean

  override def handleMessage(msg: SimulationMessage,
                    ctx: SimulationContext) {
    msg match {
      case PingRequest(ip, sender) if hasIpAddress(ip) =>
        ctx respond (sender, PingResponse(getMacAddress(ip)))
      case _ =>
        super.handleMessage(msg, ctx)
    }
  }
}

trait Router extends MixableEntity {
  override def handleMessage(msg: SimulationMessage, ctx: SimulationContext) {
    msg match {
      case s: SpecialMessage =>
      case _ =>
    }
  }
}

trait SimulationMessage
trait SimulationContext {
  def respond(sender: String, response: SimulationMessage)
}
trait SpecialMessage extends SimulationMessage
case class PingResponse(macAddress: String) extends SimulationMessage
case class PingRequest(ip: String, sender: String) extends SimulationMessage

