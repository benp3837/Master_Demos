import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { TranslateService } from './services/translate.service';

@Component({
  selector: 'app-root',
  imports: [FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pig-latin-translator';

  englishText: string = '';
  pigLatinText: string = '';

  //TODO: constructor inject PigLatinService
  constructor(private translateService:TranslateService) {}

  //TODO: Send the user input to the service's translate() method, and assign it to the pigLatinText variable
  translate() {
    this.translateService.translateToPigLatin(this.englishText).subscribe({
      next: (result: string) => {
        this.pigLatinText = result;
      },
      error: (err) => {
        this.pigLatinText = 'Translation failed. Try again later.';
        console.error(err);
      }
    });
  }
}
