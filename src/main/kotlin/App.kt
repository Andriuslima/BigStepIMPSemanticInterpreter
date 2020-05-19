import commands.*
import expression.arithmetic.*
import expression.arithmetic.Number
import expression.bool.*

fun main() {
    val env = Environment()
    env.add("x", 1f)
    env.add("y", 3f)
    env.add("existe", true)


    println("Initial Environment For Arithmetic Tree Example -> $env \n")
    val arithTreeExample: AbstractSyntaxTree = Sum(
            Sum(Number(10f), Number(4f)),
            Sum(
                    Minus(ArithVariable("x"), ArithVariable("y")),
                    Times(ArithVariable("y"), ArithVariable("x"))
            )
    )
    println(arithTreeExample)
    println(arithTreeExample.evaluate(env))
    println("\nFinal Environment For Arithmetic Tree Example -> $env \n")


    println("Initial Environment For Boolean Tree Example 01 -> $env \n")
    val boolTreeExample1: AbstractSyntaxTree = And(
        Neg(BoolVariable("existe")),
        Or(BoolVariable("existe"),
            Equal(ArithVariable("x"), Number(1f))
        )
    )
    println(boolTreeExample1)
    println(boolTreeExample1.evaluate(env))
    println("\nFinal Environment For Boolean Tree Example 01 -> $env \n")


    println("Initial Environment For Boolean Tree Example 02 -> $env \n")
    val boolTreeExample2: AbstractSyntaxTree = Or(
        GreaterThan(ArithVariable("y"), Number(1f)),
        LessThan(ArithVariable("x"), Number(1f))
    )
    println(boolTreeExample2)
    println(boolTreeExample2.evaluate(env))
    println("\nFinal Environment For Boolean Tree Example 02 -> $env \n")


    println("Initial Environment For Command Tree Example -> $env \n")
    val commandTreeExample: AbstractSyntaxTree = SequenceCommand(
        SkipCommand(),
        SequenceCommand(
            AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
            IfThenElseCommand(
                LessThan(ArithVariable("y"), Number(1f)),
                AssignCommand("x", ArithVariable("y")),
                AssignCommand("y", ArithVariable("x"))
            )
        )
    )
    println(commandTreeExample)
    println(commandTreeExample.evaluate(env))
    println("\nFinal Environment For Command Tree Example -> $env \n")


    println("Initial Environment For While Tree Example -> $env \n")
    val whileTreeExample: AbstractSyntaxTree = WhileCommand(
            LessThan(ArithVariable("x"), Number(5f)),
            AssignCommand("x", Sum(ArithVariable("x"), Number(1f)))
    )
    println(whileTreeExample)
    println(whileTreeExample.evaluate(env))
    println("\nFinal Environment For While Tree Example -> $env \n")


    println("Initial Environment For Do Command Tree Example -> $env \n")
    val doTreeExample: AbstractSyntaxTree = DoCommand(
            AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
            LessThan(ArithVariable("x"), Number(1f))
    )
    println(doTreeExample)
    println(doTreeExample.evaluate(env))
    println("\nFinal Environment For Do Command Tre Tree Example -> $env \n")


    println("Initial Environment For Either Tree Example -> $env \n")
    val eitherTreeCommand: AbstractSyntaxTree = EitherCommand(
        AssignCommand("x", Sum(ArithVariable("x"), Number(1f))),
        AssignCommand("y", Sum(ArithVariable("y"), Number(1f)))
    )
    println(eitherTreeCommand)
    println(eitherTreeCommand.evaluate(env))
    println("\nFinal Environment For Either Tre Tree Example -> $env \n")

}