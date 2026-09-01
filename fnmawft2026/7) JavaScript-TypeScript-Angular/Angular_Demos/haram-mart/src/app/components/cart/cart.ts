import { Component } from '@angular/core';
import { OrderService } from '../../services/order-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cart',
  imports: [CommonModule],
  templateUrl: './cart.html',
  styleUrl: './cart.css',
})
export class Cart {

  //Remember, to use the OrderService (and its array) we CONSTRUCTOR INJECT
  constructor(public orderService:OrderService){}

  /* 
  "get" is a very useful keyword that lets us use a function as if it's a variable
  See how we call it in the HTML
  */
  get cartSummary(): any[] {

    const counts: any = []

    //Either add the first item of its id to the cart, or increment the quantity by 1
    for(let item of this.orderService.cart){
      if(counts[item.id]){
        counts[item.id].quantity++
      } else {
        counts[item.id] = {...item, quantity:1}
      }
    }

    return Object.values(counts)

  }

  deleteItem(id:number){
    this.orderService.cart = this.orderService.cart.filter((item:any) => item.id !== id)
  }

  makePurchase(){

    //TODO: some kind of payment processing, POST to store transaction, etc.
    alert("It's clear that you love your daughter!")
    this.orderService.cart = []
  }


}
