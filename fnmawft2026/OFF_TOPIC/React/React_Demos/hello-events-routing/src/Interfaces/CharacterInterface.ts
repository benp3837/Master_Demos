//Remember, Interfaces in TS are like Model Classes in Java - they represent data

//We will use this Interface in the Character and CharacterList components
//So it's nice to have it global, instead of rewriting it twice
export interface CharacterInterface {

    name:string,
    house?:string, 
    quote:string

    //"?" means the value is optional, so we aren't required to add a value for it
    //maybe one of our Harry Potter characters can't do magic

}