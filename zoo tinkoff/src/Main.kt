interface Animal {
    val weight: Double
    val age: Int
}

interface Dog : Animal {
    val biteType: BiteType
}

interface Cat : Animal {
    val behaviorType: BehaviorType
}

enum class BiteType {
    STRAIGHT, OVERBITE, UNDERBITE
}

enum class BehaviorType {
    ACTIVE, PASSIVE
}

class Husky(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.STRAIGHT
}

class Corgi(override val weight: Double, override val age: Int) : Dog {
    override val biteType = BiteType.UNDERBITE
}

class ScottishCat(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.PASSIVE
}

class SiameseCat(override val weight: Double, override val age: Int) : Cat {
    override val behaviorType = BehaviorType.ACTIVE
}

class ZooStore {
    fun identifyAnimal(breed: String, weight: Double, age: Int): Animal? {
        return when (breed.lowercase()) {
            "husky" -> Husky(weight, age)
            "corgi" -> Corgi(weight, age)
            "scottish cat" -> ScottishCat(weight, age)
            "siamese cat" -> SiameseCat(weight, age)
            else -> null
        }
    }
}

fun main() {
    val zooStore = ZooStore()

    val dog = zooStore.identifyAnimal("Husky", 25.0, 3)
    println("A dog: ${dog?.javaClass?.simpleName}, Weight: ${dog?.weight}, Age: ${dog?.age}, Bite Type: ${(dog as Dog).biteType}")

    val cat = zooStore.identifyAnimal("Siamese Cat", 4.5, 2)
    println("A cat: ${cat?.javaClass?.simpleName}, Weight: ${cat?.weight}, Age: ${cat?.age}, Behavior Type: ${(cat as Cat).behaviorType}")
}