import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { OrderService } from '../../services/order-service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-products',
  imports: [CommonModule],
  templateUrl: './products.html',
  styleUrl: './products.css',
})
export class Products {

    //Components don't need constructors unless we're INJECTING things
    constructor(private orderService:OrderService, private toastr:ToastrService){}


    //Defining some items to display on the products page
    //Imagine this data is the body of an HTTP response (GET to /items?)
    itemList = [
        {id:1, name:"Barbie", price:500, image:"/barbie.png"},
        {id:2, name:"Lululemon Dance Studio Mid Rise Jogger", price:118, image:"/jogger.png"},
        {id:3, name:"Slime", price:5, image:"/slime.png"},
        {id:4, name:"Slime", price:5, image:"/slime.png"},
        {id:5, name:"Slime", price:5, image:"/slime.png"},
        {id:6, name:"Slime", price:5, image:"/slime.png"}
    ]

    //When "add to cart" is clicked, add the item to cart[] in the OrderService
    addToCart(item:any){
      alert("Adding " + item.name)
      this.orderService.cart.push(item)
             this.toastr.success("Added " + item.name, "Father Points +1", {
          positionClass:"toast-bottom-right"
        })
    }


    //TODO: I want a user feedback section (two way binding)

}
