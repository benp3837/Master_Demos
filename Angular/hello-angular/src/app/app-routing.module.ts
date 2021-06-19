import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnotherComponentComponent } from './components/another-component/another-component.component';

//This is the more dynamic way to display components! ROUTING!!!
//We use routing to move components in and out of the page
//For this basic demo, we have to manually append /another to our URL to see this
//But in the future, we'll use our webpage logic to move components around
const routes: Routes = [{
  path:"another",
  component: AnotherComponentComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
