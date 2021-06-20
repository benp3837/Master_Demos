import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TodosBannerComponent } from './components/todos-banner/todos-banner.component';

//This is the NgModule, which makes the various parts of our application aware of each other.
@NgModule({
  declarations: [ //declarations are "native" components that we created
    AppComponent,
    TodosBannerComponent
  ],
  imports: [ //imports are other modules that we'll use as dependencies
    BrowserModule,
    AppRoutingModule
  ],
  providers: [], //providers are where we put services. (pure-logic TS files to give functionality).
  bootstrap: [AppComponent] //The bootstrap is the first page returned to the user
                            //So in this case, it's the HTML file of the AppComponent
})
export class AppModule { }
