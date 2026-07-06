import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HelloComponent } from './components/hello/hello.component';
import { BuyComponent } from './components/buy/buy.component';
import { CartComponent } from './components/cart/cart.component';

const routes: Routes = [
  {
    path:"",
    component: HelloComponent
  },
  {
    path:"buy",
    component: BuyComponent
  },
  {
    path:"cart",
    component: CartComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
