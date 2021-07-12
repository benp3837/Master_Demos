import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { PokedexComponent } from './components/pokedex/pokedex.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { PoketypePipe } from './pipes/poketype.pipe';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    PokedexComponent,
    NavbarComponent,
    PoketypePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule //we had to import manually... Maybe too deep in the folders for Angular to find?
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
