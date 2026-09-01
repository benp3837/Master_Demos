import { Injectable } from '@angular/core';

//This is what makes Services injectable into Components
@Injectable({
  providedIn: 'root',
})

//Here's a very basic Service - no funcitons or anything, just the items added to cart
//Products needs to add stuff to cart. Cart needs to display that stuff.
  //We need to INJECT this Service into both!
export class OrderService {

  cart:any = [] //this gets filled in the Products component

}
