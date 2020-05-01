package arithexpression

import AbstractSyntaxTree
import Environment

class Number(val value: Float) : ArithExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String {
        return value.toString()
    }

}