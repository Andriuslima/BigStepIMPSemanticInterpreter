package commands

import AbstractSyntaxTree
import Environment
import kotlin.random.Random

class EitherCommand(private var c1: Command, private var c2: Command) : Command() {

    override fun evaluate(env: Environment): AbstractSyntaxTree {

        if (Random.nextBoolean()){
            println("Running c1: $c1")
            return c1.evaluate(env)
        }

        println("Running c2: $c2")
        return c2.evaluate(env)
    }

    override fun toString(): String {
        return "either $c1 or $c2"
    }
}