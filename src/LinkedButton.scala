trait Clickable {
  def click() {}
}
trait Button extends Clickable {
  override def click() { println("I'm a button") }
}
trait Link extends Clickable {
  override def click() { println("I'm a link") }
}
class LinkedButton extends Link with Button

object Test extends App {
  new LinkedButton().click()
}