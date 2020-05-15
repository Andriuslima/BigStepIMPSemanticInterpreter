package commands

import AbstractSyntaxTree
import Environment
import expression.Expression
import expression.arithmetic.ArithVariable
import expression.arithmetic.Number
import expression.bool.BoolValue
import expression.bool.BoolVariable

class AssignCommand(private var variable: String, private var value: Expression) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Assigning $this")
        when (val evaluatedValue = value.evaluate(env)) {
            is Number -> env.update(variable, evaluatedValue.value)
            is BoolValue -> env.update(variable, evaluatedValue.value)
            is ArithVariable -> env.update(variable, evaluatedValue.value(env))
            is BoolVariable -> env.update(variable, evaluatedValue.value(env))
            else -> env.update(variable, evaluatedValue)
        }

        return this
    }

    override fun toString(): String {
        return "$variable := $value"
    }
}