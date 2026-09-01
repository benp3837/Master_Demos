//DOM SELECTION - How to access HTML elements from JS
const p1 = document.getElementById("p1")

//TODO: print it out

//Now that we've DOM SELECTED the element, we can manipulate it
//This is DOM MANIPULATION
p1.setAttribute("style", "color:blue; font-weight:bold")
p1.setAttribute("title", "I was given a title via JS")

//These^ are easy DOM MANIPULATION examples, 
//But we won't really do this

//Most times, our DOM MANIPULATION will be through EVENT LISTENERS
//Event Listeners let us attach functionality to our HTML

//DOM SELECT the button and give it functionality
const button = document.getElementById("btn")

//Attach a "click" event to the button
button.addEventListener("click", buttonFunction)
//addEventListener takes 2 params: 
    //1) the event to listen for 
    //2) the function to invoke when the event fires

//Attaching Event Listeners quicker with the on___() functions
const header = document.getElementById("header")

//Much easier! no params to clutter 
header.onmouseover = mouseOverFunction
header.onmouseleave = mouseLeaveFunction


//All our functions are down here (it's ok, they get HOISTED)

function buttonFunction(){
    //alert() makes a popup on the screen -
    //fine for projects, but bad manners. look into "toasts"
    alert("Thanks for clicking :)")

    //using innerText to give p2 some content
    const p2 = document.getElementById("p2")
    p2.innerText = "I have content now thanks to the button click!"

}

function mouseOverFunction(){
    header.setAttribute("style", "color:red; font-size:50px")
    header.innerText = "DON'T TOUCH ME!!!"
}

function mouseLeaveFunction(){
    header.setAttribute("style", "color:blue; font-size:30px")
    header.innerText = "why did you leave me :("
}