import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ParentComponent } from './components/parent-component/parent-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ParentComponent], //need to import any component we plan to render
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('hello-angular');
}
