import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todos-home',
  templateUrl: './todos-home.component.html',
  styleUrls: ['./todos-home.component.css']
})
export class TodosHomeComponent implements OnInit {

  visibility:boolean = true;

  greeterDiv:boolean = true;

  name:string = "";

  //creating some variables that will be the tasks on the To Do List webpage

  //Beatles references aside, what are these? Variables pointing to what?
  //These are variables that point to {objects} that represent each of our tasks
  //Semicolons optional as usual
  todo1 = {
    id:1,
    content:"Wake up",
    status: "Incomplete"
  }

  todo2 = {
    id:2,
    content:"Fall out of bed",
    status: "Incomplete"
  }

  todo3 = {
    id:3,
    content:"Drag a comb across my head",
    status: "Incomplete"
  }

  todo4 = {
    id:4,
    content:"Find my way downstairs and drink a cup",
    status: "Incomplete"
  }

  //an Array filled the the above todo1-todo4 objects. 
  //We'll be calling from this in our HTML with String interpolation
  todosArray = [this.todo1, this.todo2, this.todo3, this.todo4];

  //this variable will toggle the visibility of our task cards 
  //We'll be calling this in our HTML with property binding
  hiddenToggle = true; //true will hide the cards. false will make them visible.


  constructor() { }

  ngOnInit(): void {

  }

  //here's the function that gets called when we click the "See your todo list" button 
  toggleVisibility() {
    this.hiddenToggle = !this.hiddenToggle; //changes the value of hiddenToggle to true/false
  }

  //when the user submits their name, it will hide the div that asks for the name
  submitName() {
    this.greeterDiv = false;
  }

}
