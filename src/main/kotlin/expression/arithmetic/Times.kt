package expression.arithmetic

import AbstractSyntaxTree
import Environment

class Times(private var expression1: ArithmeticExpression, private var expression2: ArithmeticExpression) : ArithmeticExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        var exp1: ArithmeticExpression = evaluateVariables(expression1, env)
        var exp2: ArithmeticExpression = evaluateVariables(expression2, env)

        if (exp1 !is Number) {
            println("exp1 $exp1 is not a integer, evalutaing...")
            exp1 = exp1.evaluate(env) as ArithmeticExpression
            println("exp1 evaluated as $exp1, checking exp2")
        }

        if (exp2 !is Number) {
            println("exp2 $exp2 is not a integer, evalutaing...")
            exp2 = exp2.evaluate(env) as ArithmeticExpression
            println("exp2 evaluated as $exp2, returning")
        }

        return Number((exp1 as Number).value * (exp2 as Number).value)
    }

    private fun evaluateVariables(e: ArithmeticExpression, env: Environment): ArithmeticExpression {
        if (e is ArithVariable) {
            println("First expression is a variable, evaluating...")
            println("Variable ${e.name} evaluated as ${e.value(env)}")
            return Number(e.value(env) as Float)
        }

        return e
    }

    override fun toString(): String {
        return "($expression1 * $expression2)"
    }
}