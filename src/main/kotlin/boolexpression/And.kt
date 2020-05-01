package boolexpression

import AbstractSyntaxTree
import Environment

class And(private var exp1: BoolExpression, private var exp2: BoolExpression) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        evaluateVariables(env)

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

    private fun evaluateVariables(env: Environment) {
        if (exp1 is BoolVariable) {
            println("First expression is a variable, evaluating...")
            val variable = exp1 as BoolVariable
            exp1 = BoolValue(variable.value(env) as Boolean)
            println("Variable ${variable.name} evaluated as $exp1")
        }

        if (exp2 is BoolVariable) {
            println("Second expression is a variable, evaluating...")
            val variable = exp2 as BoolVariable
            exp2 = BoolValue(variable.value(env) as Boolean)
            println("variable ${variable.name} evaluated as $exp2")
        }
    }

    override fun toString(): String {
        return "($exp1 && $exp2)"
    }
}