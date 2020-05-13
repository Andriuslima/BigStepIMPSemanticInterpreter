package commands

import AbstractSyntaxTree
import Environment

class SkipCommand : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {
        return this
    }

    override fun toString(): String {
        return "[SKIP]"
    }
}