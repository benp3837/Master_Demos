import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-child-component',
  imports: [],
  templateUrl: './child-component.html',
  styleUrl: './child-component.css',
})
export class ChildComponent {

    //We can pass data from a parent to a child with @Input
    //The value passed through property binding when the parents RENDERS the child
    @Input() index: number = 0;

}
