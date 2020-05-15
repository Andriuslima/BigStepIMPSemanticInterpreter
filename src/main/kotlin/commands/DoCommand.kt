package commands

import AbstractSyntaxTree
import Environment
import expression.bool.BoolExpression
import expression.bool.BoolValue

class DoCommand(private val c: Command, private val b: BoolExpression) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        print("Evaluating loop: \n $this")

        c.evaluate(env)

        return WhileCommand(b, c)

    }

    override fun toString(): String {
        return """
            Do {
                $c
            } while $b
        """.trimIndent() + "\n"
    }
}