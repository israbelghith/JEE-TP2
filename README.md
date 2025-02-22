# **JEE - Bookstore Management**

## 📌 Description

This is a **Java EE web application** that handles multiple **GET requests** using a **single Servlet**.  
The action to execute is determined by a hidden form parameter `action`, which specifies whether the request is for:  
- **Adding a book**  
- **Adding a store**  
- **Searching for a book**  
- **Searching for a store**  

If the request is a search operation, the results are displayed on a **JSP page**.  

## ⚙️ **Technologies Used**
- **Java EE (JSP, Servlets)**
- **Apache Tomcat 9.0.97**
- **MySQL**
- **JSTL**
- **JDBC (MySQL Connector 6.0.6)**

---

## 🚀 **Features**
✅ **Single Servlet handling multiple requests**  
✅ **Dynamic page redirection based on the `action` parameter**  
✅ **One-to-Many relationship (One Store → Many Books)**  
✅ **JSP pages for displaying search results**  

---
## 🛠 Installation

### 1️⃣ Clone the repository:
```bash
git clone URL_TO_REPOSITORY
cd PROJECT_NAME
```

### 2️⃣ Import the project into an IDE (Eclipse/IntelliJ)
### 3️⃣ Add the required JAR files:
mysql-connector-java-6.0.6.jar
jstl.jar (or javax.servlet.jsp.jstl-xxx.jar if needed)

### 4️⃣ Set up the database:
Run the following SQL script to create the necessary tables:
```
CREATE TABLE magasin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE livre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(100) NOT NULL,
    prix Double(10,2) NOT NULL,
    idmagasin INT,
    FOREIGN KEY (idmagasin) REFERENCES magasin(id) ON DELETE CASCADE
);


```

### 5️⃣ Start XAMPP and access the application:
``` http://localhost:8080/PROJECT_NAME ```



