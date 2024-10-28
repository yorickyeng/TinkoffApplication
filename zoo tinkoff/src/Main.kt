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

class Husky(
    override val weight: Double,
    override val age: Int,
    override val biteType: BiteType
) : Dog

class Corgi(
    override val weight: Double,
    override val age: Int,
    override val biteType: BiteType
) : Dog

class ScottishFold(
    override val weight: Double,
    override val age: Int,
    override val behaviorType: BehaviorType
) : Cat

class Siamese(
    override val weight: Double,
    override val age: Int,
    override val behaviorType: BehaviorType
) : Cat

class ZooStore {
    fun identifyAnimal(animal: Animal): String {
        if (animal is Husky || animal is Corgi) {
            println("Dog")
        } else if (animal is Siamese || animal is ScottishFold) {
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
    val husky = Husky (25.0, 3, BiteType.UNDERBITE)
    val type = zooStore.identifyAnimal(husky)
    println(type)
}