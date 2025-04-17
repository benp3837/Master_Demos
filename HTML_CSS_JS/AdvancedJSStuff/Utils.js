//function to export to our main JS file
//Note the default parameter - if no value is given for yearsTaken, it'll default to 5.
export function learnSkill(person, skillToLearn, yearsTaken = 5){ 

    console.log(person + " has chosen to learn: " + skillToLearn)

    //setInterval - performs an action repeatedly at a set interval
    let yearCount = 0

    let interval = setInterval(() => {
        yearCount++
        console.log(person + " is on year " + yearCount)
        if(yearCount === yearsTaken){
            clearInterval(interval) //break the cycle once the amount of years is met
            console.log(yearsTaken + " years later... " + person + " is a master of "  + skillToLearn)
        }
    }, 1000); //runs every second (1000 milliseconds)

}

//Writing a "Util" style class with a bunch of importable functionality is a common tactic
//Good way to separate ugly or verbose functions to keep the main script clean
//Modularity is good to strive for in general!