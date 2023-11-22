# To-Do List Application

Created by Damian Kryzia

This version of the To-Do List Application is updated from the previous to store tasks in a database. It also features a new UI design.

### Technologies used
- Frontend: EJS (HTML), Sass (CSS), JavaScript, JQuery
- Backend: Node.js, Express.js, PostgreSQL, Sequelize

## Starting the application
- Make sure that Node.js and PostgreSQL are installed on your computer.
- Navigate to the app directory in VS Code or any other editor.
- Open a new terminal and navigate to the app directory.
- Run the ```npm install``` command to install dependencies.
- Create a new database in PostgreSQL. It can be named whatever you want. Tables will be set up by the application.
- Open the ```models/index.js``` file. You are going to see this code:
  
  ```
  const sequelize = new Sequelize("database", "username", "password", {
    host: "localhost",
    dialect: "postgres"
  });
  ```
  
  Change the ```"database", "username", "password"``` arguments to the name of your newly created database, your PostgreSQL username, and your PostgreSQL password respectively.
- Now everything is ready to use the application. Run the ```npm start``` command and open ```localhost:3000``` in your browser.
  If you wish to use a different port to run the application, open the ```index.js``` file in the main directory and change ```const port = 3000;``` to the port that you'd like to use.

## Using the application
  - The home page displays everyday tasks.
  - In the navbar at the top of the page, you can navigate to a separate page that hosts work-related tasks.
  - New tasks can be added by clicking the "Add New Item" button.
  - Tasks can be deleted by clicking their respective checkmark buttons.
