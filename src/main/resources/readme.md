Introduction to AllRecipes:
It gives web based functionality to maintain the Recipe details.

Functionality:
Service provides the functionality to save, update, select and delete the recipes from records.

Implementation:
Functionality implemented using Rest API service which covers all CRUD operations.
Service is developed using layered architecture i.e. Controller, services

Framework used:
Spring Boot framework: it provides feature to develop standalone production ready applications
with embedded tomcat server and H2 DB.
Spring security: provides basic authentications.
Spring Data JPA: to persist recipes entities in db.

Tools:
IDE: Intellij
DB: H2
Server: tomcat
Repository: GitHub

Credentials:
GitHub Repository: https://github.com/mastanjava88/ABN_Sample_Assignment.git

Swagger Url:
http://localhost:8080/swagger-ui.html
username:user
Password:pass

Rest API:
Post : http://localhost:8080/recipe/add

Request:

{

"name": "Dal Recipe",
"price": 100,
"type": "Veg",
"cookingInstructions": "In a pan take the soaked lentils and 2 to 2.5 cups water",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{

      "name": "Tuwar Dal",
      "quantity": "200g"
    
    },
    {      
      "name": "oil",
      "quantity": "50G"     
    },
	{      
      "name": "water",
      "quantity": "50ML"     
    },
	{      
      "name": "Tamoto",
      "quantity": "50G"     
    },
	{      
      "name": "onion",
      "quantity": "50G"     
    },
	{      
      "name": "chilli",
      "quantity": "10G"     
    }
]
}

Response:

{
"id": 1,
"name": "Dal Recipe",
"price": 100,
"type": "Veg",
"cookingInstructions": "In a pan take the soaked lentils and 2 to 2.5 cups water",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{
"id": 3,
"name": "water",
"quantity": "50ML"
},
{
"id": 5,
"name": "Tamoto",
"quantity": "50G"
},
{
"id": 1,
"name": "chilli",
"quantity": "10G"
},
{
"id": 2,
"name": "oil",
"quantity": "50G"
},
{
"id": 6,
"name": "onion",
"quantity": "50G"
},
{
"id": 4,
"name": "Tuwar Dal",
"quantity": "200g"
}
]
}

PUT URL: http://localhost:8080/recipe/update

Request :
{
"id": 1,
"name": "Dal Recipe",
"price": 100,
"type": "Veg",
"cookingInstructions": "In a pan take the soaked lentils and 2 to 2.5 cups water",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{
"id": 3,
"name": "water",
"quantity": "50ML"
},
{
"id": 5,
"name": "Tamoto",
"quantity": "100G"
},
{
"id": 1,
"name": "chilli",
"quantity": "20G"
},
{
"id": 2,
"name": "oil",
"quantity": "100G"
},
{
"id": 6,
"name": "onion",
"quantity": "50G"
},
{
"id": 4,
"name": "Tuwar Dal",
"quantity": "200g"
}
]
}

Response:

{
"id": 1,
"name": "Dal Recipe",
"price": 100,
"type": "Veg",
"cookingInstructions": "In a pan take the soaked lentils and 2 to 2.5 cups water",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{
"id": 3,
"name": "water",
"quantity": "50ML"
},
{
"id": 5,
"name": "Tamoto",
"quantity": "100G"
},
{
"id": 1,
"name": "chilli",
"quantity": "20G"
},
{
"id": 2,
"name": "oil",
"quantity": "100G"
},
{
"id": 6,
"name": "onion",
"quantity": "50G"
},
{
"id": 4,
"name": "Tuwar Dal",
"quantity": "200g"
}
]
}

GetRequest By ID:

http://localhost:8080/recipe/get/2

{
"id": 2,
"name": "Chicken Recipe",
"price": 200,
"type": "Non eg",
"cookingInstructions": "Chicken Recipe boiled",
"creationDate": "24-05-2022 10:35",
"ingredients": [
{
"id": 8,
"name": "oil",
"quantity": "100G"
},
{
"id": 7,
"name": "Chicken",
"quantity": "500g"
}
]
}

GET ALL:

http://localhost:8080/recipe/list
[
{
"id": 1,
"name": "Dal Recipe",
"price": 100,
"type": "Veg",
"cookingInstructions": "In a pan take the soaked lentils and 2 to 2.5 cups water",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{
"id": 6,
"name": "onion",
"quantity": "50G"
},
{
"id": 5,
"name": "Tamoto",
"quantity": "100G"
},
{
"id": 4,
"name": "Tuwar Dal",
"quantity": "200g"
},
{
"id": 3,
"name": "water",
"quantity": "50ML"
},
{
"id": 1,
"name": "chilli",
"quantity": "20G"
},
{
"id": 2,
"name": "oil",
"quantity": "100G"
}
]
},
{
"id": 2,
"name": "Chicken Recipe",
"price": 200,
"type": "Non eg",
"cookingInstructions": "Chicken Recipe boiled",
"creationDate": "24-05-2022 04:35",
"ingredients": [
{
"id": 8,
"name": "oil",
"quantity": "100G"
},
{
"id": 7,
"name": "Chicken",
"quantity": "500g"
}
]
}
]
http://localhost:8080/recipe/delete/2
Record deleted
