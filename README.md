### ReceitasBackSpringBoot

This is the back-end repository for the Recipes Project. It is built with Spring Boot and serves as an API to manage and provide recipe data to the front-end.

#### Features

- **Spring Boot**: The backend is developed using Spring Boot.
- **REST API**: Provides endpoints to fetch and manage recipe data.
- **JSON Data Storage**: Stores recipe data in JSON files.
- **OOP Principles**: Implements Object-Oriented Programming concepts.

#### Getting Started

**Prerequisites**

- Java 11 or higher
- Maven

**Installation**

1. Clone the repository:

   ```bash
   git clone https://github.com/alexoliveiramartins/ReceitasBackSpringBoot.git
   cd ReceitasBackSpringBoot
   ```

2. Build the project with Maven:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   mvn spring-boot:run
   ```

4. The API should now be running on `http://localhost:8080`.

**API Endpoints**

- `GET /receitas`: Fetch all recipes.
- `GET /receitas/{id}`: Fetch a specific recipe by ID.
- `POST /receitas`: Add a new recipe.
- `PUT /receitas/{id}`: Update an existing recipe.
- `DELETE /receitas/{id}`: Delete a recipe.

**Project Structure**

- `src/main/java/`: Contains the Java source code.
  - `controllers/`: REST controllers.
  - `models/`: Domain models (e.g., `Receita`, `Ingrediente`).
  - `services/`: Business logic and service classes.
  - `repositories/`: Data access logic.

#### Usage

- **API Clients**: Use tools like Postman or cURL to interact with the API.
- **Integration with Front-End**: The front-end React application consumes this API to display recipe data.

#### Tech Stack

- Spring Boot
- Maven

#### Contributing

Contributions are welcome! Please open an issue or submit a pull request.

#### License

This project is licensed under the MIT License.
