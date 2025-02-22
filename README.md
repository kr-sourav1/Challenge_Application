# ChallengeApp - Spring Boot Application

## 📌 Project Overview
ChallengeApp is a **Spring Boot** application designed for managing and tracking challenges efficiently. It is built with a **Java backend**, integrated with a **PostgreSQL database**, and deployed on **AWS Elastic Beanstalk** using an **EC2 instance** and **S3**. The application follows a **microservices architecture** and incorporates best DevOps practices.

## 🚀 Tech Stack
- **Backend:** Java, Spring Boot, Spring MVC, Spring Security, Spring Data JPA
- **Database:** H2 database, PostgreSQL (Hosted on AWS RDS)
- **Build Tool:** Maven
- **Deployment:** AWS Elastic Beanstalk (EC2, RDS, IAM, S3)
- **Version Control:** Git, GitHub

## 📂 Project Structure
```
ChallengeApp/
├── src/main/java/com/challengeapp/      # Main application source code
│   ├── controller/                      # REST controllers
│   ├── service/                          # Business logic
│   ├── repository/                       # Database interaction
│   ├── model/                            # Entity classes
│   ├── config/                           # Configuration files (Security, CORS, etc.)
│   ├── ChallengeAppApplication.java      # Main Spring Boot entry point
│
├── src/main/resources/
│   ├── application.properties            # Spring Boot properties
│   ├── application.yml (optional)        # Alternative YAML configuration
│
├── .mvn/                                 # Maven Wrapper
├── mvnw, mvnw.cmd                        # Maven Wrapper Scripts
├── README.md                             # Project Documentation
└── pom.xml                                # Maven Build Configuration
```

## 🛠️ Setup & Installation
### Prerequisites
Ensure you have the following installed:
- **Java 17+**
- **Maven**
- **H2 database**
- **insomnia**
- **PostgreSQL** (if running locally)
- **AWS CLI** (for deployment)
- **Intellij**
- **Visual Studio Code**

### 🔹 Clone the Repository
```sh
git clone https://github.com/yourusername/ChallengeApp.git
cd ChallengeApp
```

### 🔹 Configure Environment Variables
Create an `.env` file or update `application.properties` with:
```properties
spring.datasource.url=jdbc:postgresql://<AWS_RDS_ENDPOINT>:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

### 🔹 Build & Run Locally
```sh
./mvnw clean package
java -jar target/ChallengeApp-0.0.1-SNAPSHOT.jar
```
OR run directly using Maven:
```sh
./mvnw spring-boot:run
```

## 🌍 Deployment on AWS Elastic Beanstalk
### **1️⃣ Package the Application**
```sh
./mvnw package
```
### **2️⃣ Deploy to AWS Elastic Beanstalk**
- Go to **AWS Elastic Beanstalk Console**
- Create a new environment (Java-based application)
- Upload the generated JAR file (`target/ChallengeApp-0.0.1-SNAPSHOT.jar`)
- Configure **EC2, IAM roles, S3, and RDS PostgreSQL**
- Assign a **public IP** to the EC2 instance

### **3️⃣ Expose the API to Public**
- Ensure the **security group** allows inbound traffic on port **5000**
- Use `curl` or insomnia to test:
```sh
curl http://<EC2_PUBLIC_IP>:5000/api/health
```

## 📌 API Endpoints (Example)
| Method | Endpoint             | Description             |
|--------|----------------------|-------------------------|
| GET    | `/api/challenges`    | Get all challenges      |
| POST   | `/api/challenges`    | Create a new challenge  |
| PUT    | `/api/challenges/{id}` | Update a challenge   |
| DELETE | `/api/challenges/{id}` | Delete a challenge   |

## 🔥 Contributing
Feel free to fork this repo and contribute via pull requests.

---
🚀 **Happy Coding!** 🎯

"# Challenge_Application" 

![Screenshot (394)](https://github.com/user-attachments/assets/74398495-029d-4742-a681-e158edb04b29)
