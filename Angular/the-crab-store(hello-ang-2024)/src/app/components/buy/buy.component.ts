import { Component } from '@angular/core';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent {

  //let's define some crabs that will be for sale when this component loads
  //in a real app, we'd probably pull this data from the backend/database
  crabList = [
    {Type:"Bay Crab", Price:300},
    {Type:"Horseshoe Crab", Price:3000},
    {Type:"Spider Crab", Price:1000},
  ]

  

}
