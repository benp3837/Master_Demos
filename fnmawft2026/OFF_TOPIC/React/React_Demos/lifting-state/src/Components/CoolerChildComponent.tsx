import "./CoolerChild.css"

//This component throws floating random colored "+1"s when you click the button
//yes I stole the template from copilot and added to it
export const CoolerChildComponent:React.FC<any> = ({incrementCounter}) => {

    const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        incrementCounter();
    
        // Create a new "+1" element
        const plusOne = document.createElement('div');
        plusOne.textContent = '+1';
        plusOne.className = 'float';
        plusOne.style.left = `${event.clientX}px`;
        plusOne.style.top = `${event.clientY}px`;
        plusOne.style.color = (() => {
            const colors = ['red', 'blue', 'green', 'purple', 'pink', 'burlywood', 'orange', 'teal', 'cerulean'];
            return colors[Math.floor(Math.random() * colors.length)];
          })(); // Assign a random color using an arrow function
    
          //set CSS variables for random direction lol
          const angle = Math.random() * 2 * Math.PI; // Random angle in radians
          plusOne.style.setProperty('--cos-angle', Math.cos(angle).toString());
          plusOne.style.setProperty('--sin-angle', Math.sin(angle).toString());

        // Append the element to the body
        document.body.appendChild(plusOne);
    
        // Remove the element after the animation ends
        plusOne.addEventListener('animationend', () => {
          plusOne.remove();
        });

        // Add bounce class to the button
        const button = event.currentTarget;
        button.classList.add('bounce');

        // Remove bounce class after animation ends
        button.addEventListener('animationend', () => {
        button.classList.remove('bounce');
        }, { once: true });

      };

    return(
        <>
            <div style={{"border":"solid 2px", "padding":"5px"}}>
                <p>cooler child component</p>
                <button onClick={handleClick}>cooler +1</button>
                <p>same parent state changing between both children!</p>
            </div>
        </>
    )

}