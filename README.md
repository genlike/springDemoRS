# springDemoRS

This is a demo springboot project to showcase common practices with MVC project.

Objective is to present a working web server with the following functionalities:

 - Authentication
 - Authorization
 - CRUD operations

All backed up by a database


The theme is about managing a persons content consumption, this means saving their books, series, movies, etc.

# Build




# Database

This project uses mongoDB.
Data is stored in two collections:

 - Users
 - Content



# Views

This being a demo we will only develop the bare minimum to showcase a working project.

List of views:
 - Home
 - Login (after loggin in we will redirect to View Content)
 - View Content (here we will also delete the content)
 - Edit Content 
 - Add Content