import commands.*
import expression.arithmetic.ArithVariable
import expression.arithmetic.Number
import expression.arithmetic.Sum
import expression.bool.*

fun main() {
    val env = Environment()
    env.add("x", 1f)
    env.add("y", 3f)
    env.add("existe", true)

//    val tree: AbstractSyntaxTree = Sum(VariableValue("x"), Number(1f))

//    val tree: AbstractSyntaxTree = Sum(
//            Sum(Number(10f), Number(4f)),
//            Sum(
//                    Minus(Number(1f), Number(9f)),
//                    Times(Number(0f), Number(56f))
//            )
//    )

//    val tree: AbstractSyntaxTree = And(BoolVariable("existe"), BoolValue(true))

//    val tree: AbstractSyntaxTree = Or(BoolVariable("existe"), BoolValue(false))

//    val tree: AbstractSyntaxTree = Neg(BoolVariable("existe"))

//    val tree: AbstractSyntaxTree = Equal(ArithVariable("x"), Number(1f))

//    val tree: AbstractSyntaxTree = GreaterThan(ArithVariable("y"), Number(1f))

//    val tree: AbstractSyntaxTree = LessThan(ArithVariable("x"), Number(1f))

//    val tree: AbstractSyntaxTree = SkipCommand()

//    val tree: AbstractSyntaxTree = AssignCommand("x", Sum(ArithVariable("x"), Number(1f)))

//    val tree: AbstractSyntaxTree = AssignCommand("x", And(BoolValue(true), BoolValue(true)))

//    val tree: AbstractSyntaxTree = SequenceCommand(
//        AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
//        SequenceCommand(
//            SkipCommand(),
//            AssignCommand("y", Sum(ArithVariable("x"), Number(1f)))
//        )
//    )

//    val tree: AbstractSyntaxTree = IfThenElseCommand(
//            LessThan(ArithVariable("y"), Number(1f)),
//            AssignCommand("x", ArithVariable("y")),
//            AssignCommand("y", ArithVariable("x"))
//    )
//
//    val tree: AbstractSyntaxTree = WhileCommand(
//            LessThan(ArithVariable("x"), Number(5f)),
//            AssignCommand("x", Sum(ArithVariable("x"), Number(1f)))
//    )

//    val tree: AbstractSyntaxTree = DoCommand(
//            AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
//            LessThan(ArithVariable("x"), Number(1f))
//    )

        val tree: AbstractSyntaxTree = EitherCommand(
        AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
        AssignCommand("y", Sum(ArithVariable("y"), Number(1f)))
    )


    println("Initial Environment -> $env \n")
    println(tree.evaluate(env))
    println("\nFinal Environment -> $env")
}