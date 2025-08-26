# Securin - Java Developer Assignment

This project is a backend RESTful API developed as a technical assignment for the Java Developer Intern role at Securin. The objective was to parse a CPE data feed, store the data in a relational database, and expose it via a paginated and searchable API using Java and the Spring Boot ecosystem.

---

## My Approach & Key Decisions

This assignment presented several real-world challenges that required strategic decisions to deliver a robust and functional backend solution.


* **Handling a Large Data Source:** The provided `official-cpe-dictionary_v2.3.xml.gz` file is a very large (over 700MB uncompressed) data source. To parse this data efficiently without consuming excessive memory, I chose to implement a **StAX (Streaming API for XML) parser**. Unlike a DOM parser which loads the entire file into memory, a StAX parser reads the XML as a stream of events, which is the industry-standard approach for handling large XML documents.

* **Database Evolution:** I initially prototyped the persistence layer with MongoDB. However, to better implement the complex, multi-parameter search functionality required by the `/api/cpes/search` endpoint, I migrated the database to **MySQL**. This allowed me to write custom, efficient JPQL queries in the repository layer to handle the specific filtering logic.

* **Focus on Backend Excellence:** As my specialization is in backend development, I focused all my efforts on creating a high-quality, fully functional, and well-documented API. To facilitate testing and interaction, I have integrated Swagger UI.

* **On Using AI Tools:** Throughout this learning-intensive project, I utilized AI-powered tools as a research and learning aid to understand new concepts, such as the intricacies of StAX parsing, ensuring that all final logic and implementation were my own.

---

## ✅ Features Implemented

* **Data Persistence:** A robust data layer built with Spring Data JPA and Hibernate to store CPE data in a MySQL database.
* **RESTful API:** A complete set of API endpoints built with Spring Boot.
* **Pagination:** The `/api/cpes` endpoint correctly implements pagination to handle large datasets efficiently.
* **Complex Search:** The `/api/cpes/search` endpoint supports dynamic, multi-parameter filtering using custom queries.
* **API Documentation:** Integrated **Swagger UI** for live, interactive API documentation and testing.

---

## 🛠️ Tech Stack

* **Language:** Java 17+
* **Framework:** Spring Boot
* **Libraries:** Spring Web, Spring Data JPA, Hibernate
* **Database:** MySQL
* **Build Tool:** Maven
* **API Documentation:** SpringDoc OpenAPI (Swagger)

---

## 🚀 How to Run the Application

#### 1. Database Setup
This project uses a MySQL database.
* Please create a new database in your local MySQL instance.
* In the `src/main/resources` folder, open the `application.properties` file.
* Update the following properties with your local database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    ```
* Hibernate (`spring.jpa.hibernate.ddl-auto=update`) will automatically create the necessary tables when the application starts.

#### 2. Run the Application
* Clone this repository to your local machine.
* Open the project in your IDE (like Eclipse or IntelliJ).
* Run the main application class `SecurinAssesmentApplication.java`.
* The application will start on the default port `8080`.

---

## 🔬 API Testing with Swagger UI

Once the application is running, you can access the interactive API documentation and test all the endpoints by navigating to the following URL in your browser:

**`http://localhost:8080/swagger-ui.html`**
