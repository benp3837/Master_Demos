import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TranslateService {

  constructor(private http:HttpClient) { }

  //TODO: send a POST request to the URL, and add the user-inputted text as the request body
  translateToPigLatin(userInput: string): Observable<string> {
    return this.http.post("http://localhost:8080/translate", userInput, {
      responseType: "text" //Telling Angular to treat the response as plain text
    })  
  }

}
