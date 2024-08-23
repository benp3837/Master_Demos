# P2Demo

## This is just the P1Demo, but with:

- JWT and Spring Security for auth, security, and password encryption on the backend
  - Login and Register require no auth. Login creates and sends a JWT in the response
    - All other requests require a JWT in the Authorization Header of all requests
  - Check the Utils package and application.properties for the JWT and Spring Security configuration
    
- Context API for global storage on the front end
  - Stores the JWT, with all the relevant user info and for use in axios requests
 
- UUIDs instead of int IDs

- public deployment. RDS, EC2, S3.
  - Check LoginComponent for S3 examples
  - Check UserController for EC2 examples
  - Check application.properties for RDS connection

