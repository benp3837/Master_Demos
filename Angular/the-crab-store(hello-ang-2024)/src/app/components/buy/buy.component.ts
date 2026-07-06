import { Component } from '@angular/core';
import { OrderService } from 'src/app/services/order.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent {

  //We need to CONSTRUCTOR INJECT the order service to use its data/functions
  constructor(private orderService: OrderService){}

  //let's define some crabs that will be for sale when this component loads
  //in a real app, we'd probably pull this data from the backend/database
  crabList = [
    {ID:1, Type:"Bay Crab", Price:300},
    {ID:2, Type:"Horseshoe Crab", Price:3000},
    {ID:3, Type:"Spider Crab", Price:1000},
  ]

  //When a crab is clicked, add it to the cart in the OrderService
  addItem(crab:any){
      this.orderService.cart.push(crab)
      alert("Added " + crab.Type)
  }

}
