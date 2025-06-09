// Import for reading user input - Groovy can use any Java library!
import java.util.Scanner

// Set up our scanner which will take user input
def scanner = new Scanner(System.in)

// Welcome message
println "Welcome to the Personality Quiz!"
print "What is your name? "
def name = scanner.nextLine()

println "\nHi, $name! Answer the following questions by typing A, B, or C:"

// Define questions and options
def questions = [
        [
                prompt: "1. What’s your ideal weekend activity?",
                options: [
                        A: "Reading",
                        B: "Hiking",
                        C: "Partying"
                ]
        ],
        [
                prompt: "2. What do you do if you're stressed?",
                options: [
                        A: "Journal or talk it out",
                        B: "Sleep",
                        C: "Exercise"
                ]
        ],
        [
                prompt: "3. What do you strive for the most in life?",
                options: [
                        A: "Personal growth",
                        B: "Achieving goals",
                        C: "Making others happy"
                ]
        ]
]

// Score counters
def scoreMap = [A: 0, B: 0, C: 0]

// Ask each question
questions.each { question ->
    println "\n" + question.prompt
    question.options.each { key, value ->
        println "   $key. $value"
    }

    def answer
    while (true) {
        print "Your answer: "
        answer = scanner.nextLine().toUpperCase()
        if (['A', 'B', 'C'].contains(answer)) break
        println "Please enter A, B, or C."
    }

    scoreMap[answer]++
}

// Determine personality type
def personality = ""
def maxChoice = scoreMap.max { it.value }.key

switch (maxChoice) {
    case "A":
        personality = "Thinker - You’re introspective and wise!"
        break
    case "B":
        personality = "Doer - You’re energetic and love to achieve!"
        break
    case "C":
        personality = "Socialite - You thrive around people and bring joy!"
        break
}

// Result
println "\nThanks for playing, $name!"
println "Your personality type is: $personality"

