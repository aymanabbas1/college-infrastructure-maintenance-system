# College Infrastructure Maintenance System

## Overview

The College Infrastructure Maintenance System is a web application designed to manage maintenance requests for college infrastructure. 
## Features

- **User Functions**:
  - Submit detailed maintenance requests.
- **Admin Functions**:
  - Manage maintenance requests.
  - Assign staff to requests.
  - Track request progress.
  - Update request status upon completion.

## Tools and Technologies used
- **Java**: For backend development.
- **JSP**: For rendering web pages.
- **Servlets**: For handling HTTP requests and responses.
- **JDBC (Java Database Connectivity)**: For database operations.
- **MySQL**: For database management.
- **CSS**: For styling the web application.
- **Maven**: For build automation and project management.



## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your machine.
- **Apache Tomcat**: A servlet container to run the application.
- **MySQL**: A database server to host the application's data.
- **Maven**: For managing the project's build process.

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/college-infrastructure-maintenance-system.git
   cd college-infrastructure-maintenance-system




## Configuration

### Database Configuration

Update the `web.xml` and `context.xml` files with your database connection details.


## Development

### Running Locally

1. Start Tomcat:

```bash
cd /path/to/tomcat/bin
./startup.sh
```

2. Access the Application:

Visit [http://localhost:8080/college-infrastructure-maintenance-system](http://localhost:8080/college-infrastructure-maintenance-system) in your web browser.

### Building the Project

Use Maven to build the project:

```bash
mvn clean install
```

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License. 



