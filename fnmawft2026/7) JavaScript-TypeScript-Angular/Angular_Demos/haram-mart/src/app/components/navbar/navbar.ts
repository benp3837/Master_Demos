import { NgStyle } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [NgStyle, RouterLink], //need to import NgStyle and RouterLink if we wanna use them
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class Navbar {

  logo = "/image.png"

  //color changing logic
  headerColor = "red";

  //change the color to a random hex value (100% copilot, why would I try this by hand?)
  changeColor() {
    const randomColor = "#" + Math.floor(Math.random() * 16777215).toString(16);
    this.headerColor = randomColor;
  }

}
