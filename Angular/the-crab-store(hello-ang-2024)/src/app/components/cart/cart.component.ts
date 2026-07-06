import { Component } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent {

  // We need to CONSTRUCTOR INJECT the order service to use its data/functions
  constructor(public orderService: OrderService){}

  /*Computed display-friendly view of the raw cart
  "get" is SUPER useful cuz it lets us use this function as if it's a variable
  See how we call it in the HTML*/
 get cartSummary(): any {
  const counts: any = {};
  for (let crab of this.orderService.cart) {
    if (counts[crab.Type]) {
      counts[crab.Type].quantity++;
    } else {
      counts[crab.Type] = { ...crab, quantity: 1 };
    }
  }
  return Object.values(counts);
}


  deleteItem(){
    
  }

  makePurchase(){

  }

}
