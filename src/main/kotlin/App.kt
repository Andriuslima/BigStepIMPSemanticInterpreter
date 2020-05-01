import arithexpression.LessThan
import arithexpression.Number

fun main() {
    val env = Environment()
    env.add("x", 1f)
    env.add("y", 3f)

//    val tree: AbstractSyntaxTree = Sum(VariableValue("x"), Number(1f))

//    val tree: AbstractSyntaxTree = Sum(
//            Sum(Number(10f), Number(4f)),
//            Sum(
//                    Minus(Number(1f), Number(9f)),
//                    Times(Number(0f), Number(56f))
//            )
//    )

//    val tree: AbstractSyntaxTree = And(BoolValue(true), BoolValue(true))

//    val tree: AbstractSyntaxTree = Or(BoolValue(false), BoolValue(false))

//    val tree: AbstractSyntaxTree = Neg(BoolValue(false))

//    val tree: AbstractSyntaxTree = Equal(Number(1f), Number(1f))

//    val tree: AbstractSyntaxTree = GreaterThan(Number(1.1f), Number(1f))

    val tree: AbstractSyntaxTree = LessThan(Number(1.1f), Number(1f))

    println("Initial Environment -> $env \n")
    println(tree.evaluate(env))
    println("\nFinal Environment -> $env")
}