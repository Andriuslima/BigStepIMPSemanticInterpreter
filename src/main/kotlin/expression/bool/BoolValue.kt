package expression.bool

import AbstractSyntaxTree
import Environment

class BoolValue(val value: Boolean) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String {
        return value.toString()
    }

}