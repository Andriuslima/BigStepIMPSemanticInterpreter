package boolexpression

import AbstractSyntaxTree
import Environment

class BoolVariable(val name: String) : BoolExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String { return name }

    fun value(env: Environment): Any {
        return env.read(name)
    }

}