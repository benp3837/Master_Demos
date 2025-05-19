import { Component } from '@angular/core';
import { ChildComponentComponent } from '../child-component/child-component.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-parent-component',
  imports: [ChildComponentComponent, CommonModule, FormsModule],
  templateUrl: './parent-component.component.html',
  styleUrl: './parent-component.component.css'
})
export class ParentComponentComponent {

  message:string = "Hello from the TS file! Angular data binding is cool."

  //Defining an Array that we'll use when rendering the child components
  arr:number[] = [1, 2, 3, 4]

  hideDiv:boolean = true

  //hide or unhide the div. we need to use "this" to refer to variables defined in "this" file 
  toggleHideDiv(){
      this.hideDiv = !this.hideDiv
  }

  //This will get filled with two-way binding
  name:string = ""
}
