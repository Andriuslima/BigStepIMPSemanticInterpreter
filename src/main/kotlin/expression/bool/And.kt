package expression.bool

import AbstractSyntaxTree
import Environment

class And(private var expression1: BoolExpression, private var expression2: BoolExpression) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        var exp1: BoolExpression = evaluateVariables(expression1, env)
        var exp2: BoolExpression = evaluateVariables(expression2, env)

        if (exp1 !is BoolValue) {
            println("exp1 $exp1 is not a boolean, evalutaing...")
            exp1 = exp1.evaluate(env) as BoolExpression
            println("exp1 evaluated as $exp1, checking exp2")
        }

        if (exp2 !is BoolValue) {
            println("exp2 $exp2 is not a boolean, evalutaing...")
            exp2 = exp2.evaluate(env) as BoolExpression
            println("exp2 evaluated as $exp2, returning")
        }

        return BoolValue((exp1 as BoolValue).value && (exp2 as BoolValue).value)
    }

    private fun evaluateVariables(e: BoolExpression, env: Environment): BoolExpression {
        if (e is BoolVariable) {
            println("Expression $e is a variable, evaluating...")
            println("Variable ${e.name} evaluated as ${e.value(env)}")
            return BoolValue(e.value(env) as Boolean)
        }

        return e
    }

    override fun toString(): String {
        return "($expression1 && $expression2)"
    }
}