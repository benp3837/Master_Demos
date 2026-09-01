const userId = localStorage.getItem("userId") 
//by getting this ID we can easily send personalized HTTP requests

document.getElementById("header").append(localStorage.getItem("username"))

//Here's how to do something on page load
window.onload = loadAnimals;

async function loadAnimals() {

    try {
        const response = await fetch(
            "http://localhost:8080/animals"
        );

        const animals = await response.json();

        const tableBody = document.getElementById("animalTableBody");

        //create a new row for each animal returned! v dynamic behavior
        animals.forEach(animal => {

            //note that each animal is individually accessible from here
            console.log(animal)

            const row = document.createElement("tr");

            row.innerHTML = `
                <td>${animal.animalId}</td>
                <td>${animal.name}</td>
                <td>${animal.species}</td>
            `;

            tableBody.appendChild(row); //appendChild() is what adds the new element to the table
        });

    } catch (error) {
        console.error(error);
    }
}