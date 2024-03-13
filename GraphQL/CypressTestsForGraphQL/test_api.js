console.log("sanity check")

fetch('https://pokeapi.co/api/v2/pokemon/mudkip').then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok :(((');
    }
    return response.json();
  })
  .then(data => {
    console.log(data); // Handle the data received from the API
  })



fetch('http://localhost:8080/graphql', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    // Add any other headers if needed
  },
  body: JSON.stringify({
    query: "query allBooks { books { bookId name pageCount author { firstName lastName } } }",
    // You can include variables or other parameters here if needed
  }),
})
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok :(((');
    }
    return response.json();
  })
  .then(data => {
    console.log(data); // Handle the data received from the API
  })
  .catch(error => {
    console.error('There was a problem with your fetch operation:', error);
  });
