package expression.arithmetic

import AbstractSyntaxTree
import Environment

class Number(val value: Float) : ArithmeticExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String {
        return value.toString()
    }

}