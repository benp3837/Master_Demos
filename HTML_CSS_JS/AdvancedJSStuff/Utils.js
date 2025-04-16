//function to export to our main JS file
//Note the default parameter - if no value is given for yearsTaken, it'll default to 5.
export function learnSkill(person, skillToLearn, yearsTaken = 5){ 

    console.log(person + " has chosen to learn: " + skillToLearn)

    console.log(yearsTaken + " years later... " + person + " is a master of "  + skillToLearn)

}

//Writing a "Util" style class with a bunch of importable functionality is a common tactic
//Good way to separate ugly or verbose functions to keep the main script clean
//Modularity is good to strive for in general!