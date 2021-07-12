import { Component, OnInit } from '@angular/core';
import { Pokemon } from 'src/app/models/pokemon';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit { //OnInit is part of the lifecycle. 
                                                  //So this all runs after the constructor runs

  //I left this as type 'any' instead of type Pokemon... it wouldn't let me assign type Pokemon to null
  public pokemon:any = null; //where is this getting its Type? We need to create a Pokemon object!
  public input:number = 0; //this is the input variable referred to by the two way binding in the TS.

  constructor(private ps:PokemonService) { } //constructor injection of the PokemonService

  ngOnInit(): void {
  }

  //This is the function that gets our Pokemon object, given a user input
  //It uses the function we defined in the Pokemon Service
  //This will return an observable. We need to subecribe to it in order to get the message it receives!!
  getPoke():void{
    this.ps.getPokemonFromApi(this.input).subscribe(
      (data:Pokemon)=>{ //this is the data we get out of the observable using subscribe
        this.pokemon=data; //assign it to a the pokemon variable above
      },
      () => { //in case of errors, set the pokemon variable to null, since we didn't get anything back
        this.pokemon = null;
        console.log("Something went wrong trying to catch your pokemon :(")
      }
    )
  }

}
