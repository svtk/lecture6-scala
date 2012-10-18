import collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int)
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}

class MyQueue extends BasicIntQueue with Doubling

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

object StackableModifications extends App {
  val idq = (new BasicIntQueue with Incrementing with Doubling)
  val diq = (new BasicIntQueue with Doubling with Incrementing)

  idq.put(2)
  diq.put(2)

  println(idq.get()) //5 = 2 * 2 + 1
  println(diq.get()) //6 = (2 + 1) * 2
}
