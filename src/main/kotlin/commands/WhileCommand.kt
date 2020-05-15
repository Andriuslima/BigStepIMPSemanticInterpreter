package commands

import AbstractSyntaxTree
import Environment
import expression.bool.BoolExpression
import expression.bool.BoolValue

class WhileCommand(private val b: BoolExpression, private val c: Command) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        print("Evaluating loop: \n $this")

        val expressionResult = b.evaluate(env) as BoolValue

        if (expressionResult.value) {
            println("Loop condition is true, entering...")
            c.evaluate(env)
            println("Env after {$c} was evaluated: $env")
            return WhileCommand(b, c).evaluate(env)
        }

        return this

    }

    override fun toString(): String {
        return """
            while $b {
                $c
            }
        """.trimIndent() + "\n"
    }
}