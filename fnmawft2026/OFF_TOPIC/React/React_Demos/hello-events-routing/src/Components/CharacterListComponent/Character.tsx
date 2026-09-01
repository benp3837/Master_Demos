import { CharacterInterface } from "../../Interfaces/CharacterInterface";

//This component is responsible for rendering a Character's data... 
//So it takes props of CharacterInterface type
export const Character:React.FC<CharacterInterface> = (character:CharacterInterface) => {


    return(
        <>
            {/* Conditional Rendering since the character may not have a house */}
            <h3>{character.name} from {character.house ? character.house : "No Affiliated House"}</h3>

            <h4>{character.name} says {character.quote}</h4>
        </>
    )

}