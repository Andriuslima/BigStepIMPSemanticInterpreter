package boolexpression

import AbstractSyntaxTree
import Environment

class Neg(private var exp1: BoolExpression) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        evaluateVariables(env)

        if (exp1 !is BoolValue) {
            println("exp1 $exp1 is not a boolean, evalutaing...")
            exp1 = exp1.evaluate(env) as BoolExpression
            println("exp1 evaluated as $exp1, checking exp2")
        }

        return BoolValue(!(exp1 as BoolValue).value)
    }

    private fun evaluateVariables(env: Environment) {
        if (exp1 is BoolVariable) {
            println("First expression is a variable, evaluating...")
            val variable = exp1 as BoolVariable
            exp1 = BoolValue(variable.value(env) as Boolean)
            println("Variable ${variable.name} evaluated as $exp1")
        }
    }

    override fun toString(): String {
        return "(!$exp1)"
    }
}