import java.util.*
import java.util.stream.Collectors

class Environment {
    private var envValues: HashMap<String, Any> = HashMap()

    fun add(key: String, value: Any) {
        envValues[key] = value
    }

    fun update(key: String, value: Any) {
        envValues.replace(key, value)
    }

    fun read(key: String): Any {
        return envValues[key] ?: 0f
    }

    override fun toString(): String {
        return envValues.keys
            .stream()
            .map { key -> "[$key:${read(key)}]" }
            .collect(Collectors.joining(" "))
    }
}