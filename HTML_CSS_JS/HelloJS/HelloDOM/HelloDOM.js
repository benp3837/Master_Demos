//I want all my divs with the classname coolclassname.
let divElements = document.getElementsByClassName("coolclassname");

console.log(typeof divElements); //object

//We can also access certain elements in the object
let firstDiv = divElements[0];
console.log(firstDiv); //the div's contents will print out

//we can set attributes of elements, though it's not the best practice
//there's an actual style object you can set properties of for every element
firstDiv.setAttribute("style", "background-color:pink;");

console.log("=======================(events)")

//now let's assign a variable that applies to all buttons
let myButton = document.getElementsByTagName('button')[0];

myButton.onclick = domFunc; //so now when a button is clicked, this function runs

function domFunc(){
    console.log("domFunc is running!");
    document.getElementById("b1").textContent = "Thanks for the click!";
    document.getElementById("p3").textContent = "Now I have content!";
}
