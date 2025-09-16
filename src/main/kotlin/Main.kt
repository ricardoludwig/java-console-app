import java.util.Scanner

/**
 * A simple Person class with attributes
 */
data class Person(
    var name: String = "",
    var age: Int = 0,
    var occupation: String = "",
    var hobbies: MutableList<String> = mutableListOf()
)

/**
 * Main application for reading person attributes from console
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val person = Person()
    
    println("=== Person Profile Creator ===")
    
    // Read name
    print("Enter name: ")
    person.name = scanner.nextLine()
    
    // Read age with validation
    var validAge = false
    while (!validAge) {
        print("Enter age: ")
        try {
            val ageInput = scanner.nextLine()
            person.age = ageInput.toInt()
            if (person.age < 0 || person.age > 120) {
                println("Please enter a valid age between 0 and 120")
            } else {
                validAge = true
            }
        } catch (e: NumberFormatException) {
            println("Please enter a valid number for age")
        }
    }
    
    // Read occupation
    print("Enter occupation: ")
    person.occupation = scanner.nextLine()
    
    // Read hobbies
    println("Enter hobbies (type 'done' when finished):")
    var hobby: String
    do {
        print("> ")
        hobby = scanner.nextLine()
        if (hobby.lowercase() != "done" && hobby.isNotEmpty()) {
            person.hobbies.add(hobby)
        }
    } while (hobby.lowercase() != "done")
    
    // Display the profile
    println("\n=== Person Profile ===")
    println("Name: ${person.name}")
    println("Age: ${person.age}")
    println("Occupation: ${person.occupation}")
    println("Hobbies: ${if (person.hobbies.isEmpty()) "None" else person.hobbies.joinToString(", ")}")
    
    // Ask if user wants to save the profile
    print("\nDo you want to save this profile? (yes/no): ")
    val saveResponse = scanner.nextLine()
    
    if (saveResponse.equals("yes", ignoreCase = true)) {
        println("Profile saved successfully!")
        // Here you would typically add code to actually save the data to a file or database
    } else {
        println("Profile not saved.")
    }
    
    println("Thank you for using the Person Profile Creator!")
}
