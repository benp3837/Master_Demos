//you can just use true or false, but we're making booleans for clarity. 
//remember - element.addEventListener(event, function, useCapture) <-boolean goes in useCapture
const bubbling = false; 
const capturing = true; 

document.getElementById("inner").addEventListener("click", (event)=> {
  console.log("INNER - capturing")
}, capturing);

document.getElementById("middle").addEventListener("click", ()=> {
  console.log("MIDDLE - capturing")
}, capturing);

document.getElementById("outer").addEventListener("click", ()=> {
  console.log("OUTER - capturing")
}, capturing);

//running these three event listeners alone will print only "OUTER - capturing" if you click outer
//BUT it'll print all three if you click inner

document.getElementById("inner").addEventListener("click", ()=> {
  console.log("INNER - bubbling")
  //event.stopImmediatePropagation(); this will stop bubbling from happening after INNER
}, bubbling);

document.getElementById("middle").addEventListener("click", ()=> {
  console.log("MIDDLE - bubbling");
}, bubbling);

document.getElementById("outer").addEventListener("click", ()=> {
    console.log("OUTER - bubbling")
}, false);