interface Animal {
    val weight: Double
    val age: Int
}

interface Dog : Animal {
    val biteType: BiteType
}

enum class BiteType {
    STRAIGHT, OVERBITE, UNDERBITE
}

interface Cat : Animal {
    val behaviorType: BehaviorType
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

class Husky(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.UNDERBITE
}

class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.STRAIGHT
}

class ScottishFold(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.PASSIVE
}

class Siamese(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.ACTIVE
}

class ZooStore {
    fun identifyAnimal(animal: Animal): String {
        if (animal is Dog) {
            println("Dog")
        } else if (animal is Cat) {
            println("Cat")
        }

        return when (animal) {
            is Husky -> "Husky with weight ${animal.weight} and age ${animal.age}"
            is Corgi -> "Corgi with weight ${animal.weight} and age ${animal.age}"
            is ScottishFold -> "Scottish Fold with weight ${animal.weight} and age ${animal.age}"
            is Siamese -> "Siamese with weight ${animal.weight} and age ${animal.age}"
            else -> throw IllegalArgumentException("Unknown animal type")
        }
    }
}

fun main() {
    val zooStore = ZooStore()
    val husky = Husky (25.0, 3)
    val type = zooStore.identifyAnimal(husky)
    println(type)
}