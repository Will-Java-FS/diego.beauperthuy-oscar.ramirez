# Project 0: Item Management Application

* Assigned Date: 7/31/2024
* Due Date: 8/06/2024

# Description

Using Spring Boot, create a simple API for creating and managing items. The items can be whatever you want (i.e. Collectibles, Animals, Employees, Video Games, Shoes, Clothing, etc). Your goal will be to build an API that allows you to store these items and track them as needed.

## Requirements
- Build the application using at least Java 17 and Spring Boot 3

- All interactions between a User and the API should happen via HTTP Requests. Using a tool like Postman will allow you to set up these requests.

- All data should be stored in a SQL Database, using an in-memory H2 database will be the easiest way to tackle this problem, though a PostgreSQL database would be ideal. Remember that we're going for persistence with a Database, so we'd likely want to either use a file for H2 or just use a PostgreSQL Database as is

- The goal of this project is to learn basic application design and structure

- You'll be expected to complete 4 of the following User Stories as a **MINIMUM**. The more stories implemented the better, but make sure you have at least 4 of the following:

    - As a user, I can create a new Item
    - As a user, I can view all Items
    - As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - As a user, I can update a Item (Change the name or other properties)
    - As a user, I can delete a Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - As a user, I can create an account to hold my Items
    - As a user, I can login to my account (which is stored in the database)
    - As a user, I can view the Items associated with my account

- Other Optional Requirements include the following:
    - Giving accounts roles (USER and ADMIN) so Admins can view everyone's Items while a User can only view their own
    - Using JUnit to test Service Layer methods (70% coverage at least would be optimal)

- **NOTE** Responses from the API must include proper response bodies (in JSON) and **status codes** (i.e. If I try to go to http://localhost:8080/To-Do/5 and there is no resource there, I should receive a 404 status code (NOT FOUND) in the response, but if the resource is there I should receive a 200 status code (OK) instead)

## Presentation
- Use Postman to showcase how your application handles HTTP requests and responses (A Collection on Postman is useful for presenting prewritten HTTP requests)
- Clear, concise, and professional communication during the project presentation
- Ability to communicate clear answers to fully address questions asked about the project
- Logical flow to the project presentation
- Approx. 5 Minutes in length

## To Do List
    - [ ] As a user, I can create a new Item
    - [ ] As a user, I can view all Items
    - [ ] As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - [ ] As a user, I can update a Item (Change the name or other properties)
    - [ ] As a user, I can delete a Item by its ID (HINT: Use Path Params to select a Item by its ID)
    - [ ] As a user, I can create an account to hold my Items
    - [ ] As a user, I can login to my account (which is stored in the database)
    - [ ] As a user, I can view the Items associated with my account

