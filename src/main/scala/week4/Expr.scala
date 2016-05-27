package week4

/**
  * Created by rizhan on 5/27/16.
  */
trait Expr{
  def eval: Int = this match{
    case Var(x) => throw new IllegalArgumentException("Failed to evaulate varaible " + x)
    case Number(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Prod(e1, e2) => e1.eval * e2.eval
  }

  def show: String = this match{
    case Var(x) => x
    case Number(n) => n.toString
    case Sum(e1, e2) => e1.show + " + " + e2.show
    case Prod(e1, e2) => e1 match{
      case Sum(sub_e1_1, sub_e1_2) => e2 match {
        case Sum(sub_e2_1, sub_e2_2) => "(" + e1.show+ ")" + " * " + "(" + e2.show+ ")"
        case _ => "(" + e1.show +")" + " * " + e2.show
      }
      case _ => e2 match {
        case Sum(sub_e2_1, sub_e2_2) => e1.show + " * " + "(" + e2.show + ")"
        case _ => e1.show + " * " + e2.show
      }
    }
  }
}
case class Number(n: Int) extends Expr
case class Var(x: String) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr