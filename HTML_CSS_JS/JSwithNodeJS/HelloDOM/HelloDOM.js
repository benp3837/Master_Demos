console.log("===============(DOM Selection/Manipulation)");

//I want to select my two divs with class = coolClassName
let divElements = document.getElementsByClassName("divClass");

//we can access the objects in the divElements HTMLCollection (which is like an Array with HTML elements)
console.log(divElements);

//like with any data structure, we can access the indexes of the HTMLCollection
console.log(divElements[0]);

//we can set attributes of elements directly (DOM Manipulation), though it's not best practice
//inline styling isn't typically preferable over external CSS, so why would this be preferable?
//one possible case: changing some existing element to red if something goes wrong 
//(but even then, there's better ways to tell the user they messed up)

//save the first element of divElements to a variable
let firstDiv = divElements[0];
firstDiv.setAttribute("style", "background-color:pink; font-family:arial");

/* shortcut for block comment in VSCcode: shift + alt + a */

console.log("(Events)==============================================================")

//Assigning a variable that applies to our button
let myButton = document.getElementById("b1");

//event listeners take in the event we're listening for, and the function to execute,
myButton.addEventListener("click", buttonFunction);

//declaring the function - hoisting! it's called before we declare it.
function buttonFunction(){
    //In this function, I want to change some of the content on our page
    myButton.textContent = "Thanks for the click!" //textContent lets us access/change the element's text

    //we can add eventListeners after DOM selection
    document.getElementById("p3").textContent = "NOW I HAVE CONTENT >:D"
}

//there is a shorter way to add event listeners, which is what I usually do----------------

//getting the h3 using DOM selection
let header = document.getElementById("header");

header.onmouseover = hoverFunction; //so now, hoverFunction will execute when we mouseover the h3

function hoverFunction(){
    header.textContent = "don't touch me!!!"
}

header.onmouseleave = releaseFunction;

function releaseFunction(){
    header.textContent = "why did you leave me :("
}