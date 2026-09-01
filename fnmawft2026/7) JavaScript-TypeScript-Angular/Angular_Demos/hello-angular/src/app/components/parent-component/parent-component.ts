import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChildComponent } from '../child-component/child-component';

@Component({
  selector: 'app-parent-component', //call this (like an HTML element) to render the component 
  imports: [CommonModule, FormsModule, ChildComponent], //Any modules or components we need get imported here
  templateUrl: './parent-component.html', //this is the HTML that gets renders
  styleUrl: './parent-component.css', //this is the CSS that will get applied to the component
})
//use the CLASSNAME to import this component into others
export class ParentComponent {

  //The TypeScipt file contains variables and functions used and rendered in the HTML

  //Defining an Array that we'll use to render child components
  arr:number[] = [1, 2, 3, 4]

  //This variable will hide the big h1
  hideHeader:boolean = true

  //This will trigger on button click
  showSurprise(){
    alert("SURPRISE!!!")
    this.hideHeader = !this.hideHeader
  }

  //defining a variable to be populated by the two way binding
  name:string = ""


}
