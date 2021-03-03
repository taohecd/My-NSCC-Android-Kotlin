package com.example.classesinterfacesenums

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.classesinterfacesenums.classes.Car
import com.example.classesinterfacesenums.enums.DayOfTheWeek
import com.example.classesinterfacesenums.enums.Directions
import com.example.classesinterfacesenums.inheritance.Animal
import com.example.classesinterfacesenums.inheritance.Cat
import com.example.classesinterfacesenums.inheritance.Dog
import com.example.classesinterfacesenums.inheritance.KomodoDragon
import com.example.classesinterfacesenums.interfaces.CornerStore
import com.example.classesinterfacesenums.interfaces.SchoolCanteen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testClasses()
        testInheritance()
        testInterfaces()
        testEnums()
    }

    private fun testClasses() {
        // here we call our primary constructor
        val audi = Car("Audi", 200)

        // here we call our secondary constructor
        val bmw = Car("BMW", 200, "Red")

        // access state of our object (instance variables)
        val audiKms = audi.kms
        val bmwMake = bmw.make

        // access behavior (methods)
        audi.turnOnCar()
        bmw.turnOnCar()

        // accessing attributes of our companion object
        val carsCreated = Car.getCarCreated()
//        audi.carsCreated()  why doesn't this compile?
    }

    private fun testInheritance() {
        val fooAnimal = Animal("animal", "Brown", 1)
        val fooDog = Dog("doggo", "Black", 2, "Relaxed")
        val fooCat = Cat("kittie", "White", 1, "Fuzzy Mouse")
        val fooKomodo = KomodoDragon("Rex", "Green", 140, "Thick")

        // let's examine some state of our animals
        Log.d("Checking State", fooAnimal.name)
        Log.d("Checking State", fooDog.name)
        Log.d("Checking State", fooCat.color)
        Log.d("Checking State", fooKomodo.age.toString())

        // Since each of these objects all inherit from Animal, we can group them together
        val animals = listOf<Animal>(fooAnimal, fooDog, fooCat, fooKomodo) // a list of animals

        // We can iterate through all of them as Animals
        for (animal : Animal in animals) {
            animal.walk() // each animal walks in the same manner
            animal.speak() // each animal speaks differently (except KomodoDragon)
        }

        // let's try calling some methods of specific animal types
        fooCat.chaseMouse()
//        fooDog.chaseMouse() // why doesn't this compile?
        fooKomodo.attackHippo()
//        fooAnimal.attackHippo() // why doesn't this compile?
    }

    private fun testInterfaces() {
        val iceCreamFlavors = mutableListOf("Vanilla", "Chocolate", "Strawberry")

        val schoolCanteen = SchoolCanteen("FooHigh", iceCreamFlavors = iceCreamFlavors)

        iceCreamFlavors.remove("Vanilla")
        val cornerStore = CornerStore(iceCreamFlavors)

        // let's call some methods of our IceCreamSellers
        schoolCanteen.serveIceCream(iceCreamFlavors.random())
        cornerStore.serveIceCream("Chocolate")

        // but as SchoolCanteen and CornerStore are unique classes
        // they have their own methods as well that are unique to them
        schoolCanteen.openCanteen()
//        cornerStore.openCanteen() // why doesn't this compile
    }

    private fun testEnums() {
        // we can initialize a variable with the value of an Enum type
        val monday = DayOfTheWeek.MONDAY
        val wednesday = DayOfTheWeek.WEDNESDAY

        // we can call functions of each of our Enum type variables
        monday.greet()
        wednesday.greet()

        // it is really useful to type check against a value with a when statement
        val excitementForTheWeekend = when (DayOfTheWeek.values().random()) {
            DayOfTheWeek.MONDAY -> 1
            DayOfTheWeek.TUESDAY -> 2
            DayOfTheWeek.WEDNESDAY -> 3
            DayOfTheWeek.THURSDAY -> 4
            DayOfTheWeek.FRIDAY -> 10
            DayOfTheWeek.SATURDAY -> 11
            DayOfTheWeek.SUNDAY -> 0 // what happens if we delete this entry?
        }

        // let's create a list of directions
        val directionsToTheParty = listOf(Directions.NORTH, Directions.EAST, Directions.NORTH, Directions.WEST)

        // if we didn't create an enum type we might end up with an error like this
        val moreDirections = listOf("North", "East", "nort", "WEst")

        when (moreDirections[2]) { // "nort"
            "North" -> Log.d("Directions", "Travelling North")
            "East" -> Log.d("Directions", "Travelling East") // uh oh
            "South" -> Log.d("Directions", "Travelling South")
            "West" -> Log.d("Directions", "Travelling West")
        }

        // what happens if we try to add a new direction to our "moreDirections" list, such as "South West"

        // our "when" statement up above is going to compile, but we haven't actually handled the case of "South West"
        // this is why we use Enums, it forces us to handle all cases

        // let's add a new entry to Directions then use a when statement to see what happens
    }
}