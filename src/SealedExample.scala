object SealedExample extends App {
  def test(term: Term) = term match {
    case Appl(a: Abst, x) => 1
    case Appl(a: Appl, x) => 1
    case Appl(Var(_), x) => 1
    case appl: Appl => 42
  }
}

sealed trait Term
case class Var(name: String) extends Term
case class Abst(v: Var, expr: Term) extends Term
case class Appl(func: Term, arg: Term) extends Term
