# Bank System Gradle Project

This repository contains the Gradle project for Bank System.

## Repository

The source code for this project is hosted on GitHub: [artonn2k/banksystem](hhttps://github.com/artonn2k/banksystem)

## Gradle Setup

To integrate this Gradle project into your development environment, follow these steps:

1. Clone this repository to your local machine:

   ```bash
   git clone https://github.com/artonn2k/banksystem.git
   ```

2. Navigate to the cloned repository:

   ```bash
   cd banksystem
   ```

3. Build the project using Gradle:

   ```bash
   ./gradlew build
   ```

4. Import the project into your preferred IDE.

## Running and Updating the Project

To run the Spring Boot application through Gradle, you can use the `bootRun` task:

```bash
./gradlew bootRun
```

This command will compile the project and start the Spring Boot application.

To clean the project, you can use the `clean` task:

```bash
./gradlew clean
```

This command will delete the build directory and clean the project. It's useful for removing temporary files and artifacts generated during the build process.

## Project Structure

The project structure follows standard Gradle conventions:

- `src/main/java`: Contains the main Java source code.
- `src/main/resources`: Contains the main resources.
- `src/test/java`: Contains the test Java source code.
- `src/test/resources`: Contains the test resources.
- `build.gradle`: Defines project configuration, dependencies, and tasks.

## Dependencies

This project utilizes several dependencies managed by Gradle:

- Spring Boot for web application development.
- Spring Data JPA for data access.
- PostgreSQL driver for connecting to a PostgreSQL database.
- Springdoc OpenAPI for API documentation.
