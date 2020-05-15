package expression.bool

import AbstractSyntaxTree
import Environment
import kotlin.math.exp

class Neg(private var expression: BoolExpression) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        var exp1: BoolExpression = evaluateVariables(expression, env)

        if (exp1 !is BoolValue) {
            println("exp1 $exp1 is not a boolean, evalutaing...")
            exp1 = exp1.evaluate(env) as BoolExpression
            println("exp1 evaluated as $exp1, checking exp2")
        }

        return BoolValue(!(exp1 as BoolValue).value)
    }

    private fun evaluateVariables(e: BoolExpression, env: Environment): BoolExpression {
        if (e is BoolVariable) {
            println("First expression is a variable, evaluating...")
            println("Variable ${e.name} evaluated as ${e.value(env)}")
            return BoolValue(e.value(env) as Boolean)
        }

        return e
    }

    override fun toString(): String {
        return "(!$expression)"
    }
}