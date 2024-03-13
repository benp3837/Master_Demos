describe('GraphQL API Tests', () => {
    it('Should be able to query books from the GraphQL API', () => {
      // Make a GraphQL query request to fetch books
      cy.request({
        method: 'POST',
        url: 'http://localhost:8080/graphql', // Your GraphQL API endpoint
        body: {
          query: `
            query {
              books {
                bookId
                name
                pageCount
                author {
                  authorId
                  firstName
                  lastName
                }
              }
            }
          `
        }
      }).then((response) => {
        console.log(response)
        // Validate the response status and structure
        expect(response.status).to.eq(200);
        expect(response.body.data).to.have.property('books');
        expect(response.body.data.books).to.be.an('array');
              // Perform additional assertions as needed
    });
});

// Add more test cases for mutations, error handling, etc.
});