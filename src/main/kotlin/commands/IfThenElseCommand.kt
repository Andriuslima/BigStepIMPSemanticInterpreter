package commands

import AbstractSyntaxTree
import Environment
import expression.bool.BoolExpression
import expression.bool.BoolValue

class IfThenElseCommand(private var b: BoolExpression, private var c1: Command, private  var c2: Command) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        print("Evaluating condition: \n $this")
        val expressionResult = b.evaluate(env) as BoolValue

        return if (expressionResult.value) {
            c1.evaluate(env)
        } else {
            c2.evaluate(env)
        }
    }

    override fun toString(): String {
        return """
            if $b {
                $c1
            } else {
                $c2
            }
        """.trimIndent() + "\n"
    }
}