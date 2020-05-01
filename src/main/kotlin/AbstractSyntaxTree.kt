abstract class AbstractSyntaxTree {
    abstract fun evaluate(env: Environment): AbstractSyntaxTree
}