# autoparts-onlineshop-api
Auto Parts Online Shop - API Development Task

Auto Parts Online Shop - API Development Task
You are tasked with developing a RESTful API for an auto parts online shop. The API will allow
users to browse and search for auto parts, view compatibility with different models, and provide
administrative functionality for managing the parts and their compatibility. You are required to use
Java, Maven, MySQL, Spring Boot, Hibernate, Lombok and Spring Security with JWT for
authentication.
Requirements:
1. Implement the following entities:
• Part category: Represent the type of the auto part: e.g. windshields, tires, brakes,
fluids, etc. The properties could be id, name, description and whatever else
field you find relevant.
• Part: Represents an auto part with properties like id, name, description,
price and any additional fields you find relevant.
• Make: Represents a car manufacturer with properties like id, name, and any
additional fields you find relevant.
• Model: Represents a car model with properties like id, name and any additional
fields you find relevant.
2. Create the necessary relationships between entities:
• A Part can belong to only one Category. Implement a one-to-many relationship
between the part and category.
• A Model can belong to only one Make. Implement a one-to-many relationship
between the make and the model.
• A Part can be compatible with multiple Models, and a Model can be compatible with
multiple Parts. Implement a many-to-many relationship between Part and Model.
3. Implement the following API endpoints:
• GET /makes: Retrieve a list of all the manufacturers available in the shop.
• GET /models/{make?}: Retrieve a list of all the car models available in the shop,
optionally filtered by the manufacturer.
• GET /parts: Retrieve a list of all parts available in the shop.
• GET /parts/{id}: Retrieve details of a specific part by its ID, including, but not
limited to, it’s compatibility listings
• GET /parts/{category}/{model?}: Retrieve the list of all parts for a specific
category, and (optionally) compatible with a specific auto model.
• GET /parts/search?name={name}: Retrieve the list of all parts in all categories,
which name could match the query predicate.
4. Implement the following additional endpoints for administrative functionality:
• GET /makes/{id}: Retrieve details of a specific make by its ID.
• GET /models/{id}: Retrieve details of a specific car model by its ID.
• POST /makes: Create a new manufacturer.
• POST /models: Create a new car model.
• PUT /makes/{id}: Update an existing car make.
• PUT /models/{id}: Update an existing car model.
• DELETE /makes/{id}: Delete a manufacturer.
• DELETE /models/{id}: Delete a car model.
• POST /parts: Create a new part.
• PUT /parts/{id}: Update an existing part, including, but not limited to, it’s
compatibility listings.
• DELETE /parts/{id}: Delete a part.
5. Ensure that the API responses follow RESTful principles and return appropriate HTTP status
codes.
6. Use Spring Security with JWT for authentication and authorization. Implement the
following:
• POST /auth/signup: User registration endpoint. Allow users to create an account
with a username and password.
• POST /auth/login: User login endpoint. Authenticate users and generate a JWT
token for subsequent requests.
• Secure all other API endpoints to require authentication and validate JWT tokens.
• For the non-administrative endpoints, provide a way to call them as a guest, without
logging in.
7. Use Hibernate to persist the entities to a MySQL database. You are free to design the
database schema as you see fit.
8. Utilize Lombok to reduce boilerplate code.
9. Write unit tests for the API endpoints using a testing framework of your choice (e.g., JUnit,
Mockito).
