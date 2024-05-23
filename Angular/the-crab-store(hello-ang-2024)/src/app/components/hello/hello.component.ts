import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent {

  constructor(private router: Router) { }

  navigateToBuy() {
    this.router.navigate(['/buy']);
  }

}
