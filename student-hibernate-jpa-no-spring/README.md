# Student Hibernate JPA (No Spring Boot)

This is a minimal Java application demonstrating how to use **Hibernate (JPA)** without **Spring or Spring Boot** to perform basic CRUD operations.

---

## 🔧 Technologies Used

- Java 21
- Hibernate Core 5.6.15.Final
- JPA 2.2
- MySQL 8
- Maven
- IntelliJ IDEA

---

## 📁 Project Structure
````bash

student-hibernate-jpa-no-spring/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/shreya/jpa/
│ │ │ ├── MainApp.java
│ │ │ ├── model/Student.java
│ │ │ └── repository/StudentRepository.java
│ │ └── resources/
│ │ └── META-INF/persistence.xml
└── pom.xml
````


---

## 🗃️ Database Configuration

- **DB Name**: `foodorder`
- **Table**: `students`
- **Update Strategy**: `hibernate.hbm2ddl.auto = update`

Update `persistence.xml` with your local MySQL credentials.

---

## 📄 persistence.xml

Located at `src/main/resources/META-INF/persistence.xml`:

```xml
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
             version="2.2">
    <persistence-unit name="student-unit">
        <class>com.shreya.jpa.model.Student</class>

        <properties>
            <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/foodorder"/>
            <property name="javax.persistence.jdbc.user" value="root"/>
            <property name="javax.persistence.jdbc.password" value="your_password"/>

            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL8Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

      