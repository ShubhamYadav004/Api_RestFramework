# API_RestFramework

This is a lightweight **REST Assured-based API Automation Framework** built using Java, TestNG, and Maven. It supports modularized services, clean test structure, reusable utilities, and is scalable for large test suites.

---

## 🔧 Technologies Used

- Java
- Maven
- REST Assured
- TestNG
- Log4j2
- Git
- GitHub Actions (ready)
- POJO for payloads handle
- Properties file (for config)

---

## 📁 Project Structure

src/
│
├── main/
│ └── java/
│ └── com.api/
│ ├── base/ # Base setup for services
│ │ ├── AuthService.java
│ │ ├── BaseService.java
│ │ └── UserProfileManagementService.java
│ ├── filters/
│ │ └── LoggingFilter.java # Logs requests and responses
│ └── listeners/
│ └── TestListeners.java # ITestListener implementation
│
├── test/
│ └── java/
│ └── com.api.tests/
│ ├── LoginTest.java
│ └── UpdateProfileTest.java
│
└── resources/
└── suite.xml # TestNG XML config file
└── config.properties # Configurations like base URL
