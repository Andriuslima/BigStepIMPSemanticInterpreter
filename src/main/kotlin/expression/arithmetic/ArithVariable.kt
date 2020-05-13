package expression.arithmetic

import AbstractSyntaxTree
import Environment

class ArithVariable(val name: String) : ArithmeticExpression() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String {
        return name
    }

    fun value(env: Environment): Any {
        return env.read(name.toLowerCase())
    }

}