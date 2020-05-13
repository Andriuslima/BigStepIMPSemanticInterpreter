package commands

import AbstractSyntaxTree
import Environment

class SequenceCommand(private var c1: Command, private var c2: Command) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        c1.evaluate(env)
        c2.evaluate(env)
        return this
    }

    override fun toString(): String {
        return "$c1 ; $c2"
    }
}