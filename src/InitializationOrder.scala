trait MyProperty {
  val name: String = "default"
  override val toString = s"Property($name)"
}

class MyClass extends MyProperty {
  override val name = "hi!"
}

object InitializationOrder extends App {
  val x = new MyProperty { override val name = "hi!" }
  println(x)
}

