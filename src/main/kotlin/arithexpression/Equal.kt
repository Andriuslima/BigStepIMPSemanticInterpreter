package arithexpression

import AbstractSyntaxTree
import Environment
import boolexpression.BoolValue

class Equal(private var exp1: ArithExpression, private var exp2: ArithExpression) : ArithExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        println("Evaluating expression: $this")

        evaluateVariables(env)

        if (exp1 !is Number) {
            println("exp1 $exp1 is not a integer, evalutaing...")
            exp1 = exp1.evaluate(env) as ArithExpression
            println("exp1 evaluated as $exp1, checking exp2")
        }

        if (exp2 !is Number) {
            println("exp2 $exp2 is not a integer, evalutaing...")
            exp2 = exp2.evaluate(env) as ArithExpression
            println("exp2 evaluated as $exp2, returning")
        }

        return BoolValue((exp1 as Number).value == (exp2 as Number).value)
    }

    private fun evaluateVariables(env: Environment) {
        if (exp1 is ArithVariable) {
            println("First expression is a variable, evaluating...")
            val variable = exp1 as ArithVariable
            exp1 = Number(variable.value(env) as Float)
            println("Variable ${variable.name} evaluated as $exp1")
        }

        if (exp2 is ArithVariable) {
            println("Second expression is a variable, evaluating...")
            val variable = exp2 as ArithVariable
            exp2 = Number(variable.value(env) as Float)
            println("variable ${variable.name} evaluated as $exp2")
        }
    }

    override fun toString(): String {
        return "($exp1 + $exp2)"
    }
}