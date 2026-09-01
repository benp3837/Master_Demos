import { Routes } from '@angular/router';
import { Dashboard } from './components/dashboard/dashboard';
import { Products } from './components/products/products';
import { Cart } from './components/cart/cart';

//We register all the components we want to dynamically display here
export const routes: Routes = [

    //All routed components need: A URL that renders it, and the Classname of the component to render
    //For this one: "When the URL is "/", render the Dashboard Component"
    {
        path:"",
        component:Dashboard
    },

    {
        path:"products",
        component:Products
    },
    {
        path:"cart",
        component:Cart
    }

];
