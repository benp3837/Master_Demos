import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pokemon } from '../models/pokemon';

@Injectable({
  providedIn: 'root'
})

//Remember, the Services are what give functionality to our models
export class PokemonService {

  //Why do we put this into the constructor? So it gets dependency injected!
  constructor(private http:HttpClient) { } 

  //this method is what will get our Pokemon data from the api!
  //Note - we use a GET request to get a pokemon object, and return it as an Observable
    //Note note - we use Observables to get data from servers. Like a Promise object but better
  getPokemonFromApi(id:number):Observable<Pokemon>{ //we get an observable object that returns a Pokemon
    return this.http.get("https://pokeapi.co/api/v2/pokemon/"+id+"/") as Observable<Pokemon>; 
  }

  //this is like the easier way to do fetch()!!!
  //we just have to inject this service into the constructors of components to use it.

}