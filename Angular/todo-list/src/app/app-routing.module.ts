import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TodosHomeComponent } from './components/todos-home/todos-home.component';

//dynamically display the todos-home.component via routing!
//we want the home component (containing our task cards) to be able to switch in and out of our webpage.
const routes: Routes = [{
  path: "todos",
  component: TodosHomeComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
