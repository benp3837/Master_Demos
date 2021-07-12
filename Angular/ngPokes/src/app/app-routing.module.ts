import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

//Remember, routing lets us move components in and out of the page dynamically.
//Actions on the webpage will result in different paths, thus moving components around. 
//Also remember, these components will be switching in and out via the <router-outlet> 
  //in app.component.html.
const routes: Routes = [
  {
    path:'welcome', 
    component:WelcomeComponent
  },
  {
    path:'', //the empty String makes this the base path. So when I go to localhost:4200, we'll get this.
             //so why have any path with 'welcome' at all? In case we wanna go back to it!
    component:WelcomeComponent
  },
  {
    path:'pokedex',
    component:PokedexComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
