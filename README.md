# 🏦 ParabankSKM – Selenium Test Automation Framework

![Java](https://img.shields.io/badge/Java-17+-blue)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-orange)
![TestNG](https://img.shields.io/badge/TestNG-7.8-green)
![Maven](https://img.shields.io/badge/Maven-3.9.0-red)
![ExtentReports](https://img.shields.io/badge/Reporting-Extent_Reports-purple)

---

## 🎯 Objective
Showcase a scalable Selenium TestNG framework demonstrating strong QA automation design, reporting, and CI/CD readiness.

---

## 📌 Overview

**ParabankSKM** is a **Selenium Test Automation Framework** built using **Java, TestNG, and Maven**, designed to automate core functionalities of the **Parabank web application**.

It covers end-to-end banking workflows such as:
- User registration and login  
- Opening new accounts  
- Transferring funds  
- Applying for loans  
- Paying bills  
- Viewing account summaries  

The framework is structured using the **Page Object Model (POM)** and follows best practices in test design, reporting, and maintainability.

---

## ⚙️ Tech Stack

| Category | Tools / Technologies |
|-----------|----------------------|
| **Language** | Java (JDK 17+) |
| **Automation Tool** | Selenium WebDriver |
| **Test Framework** | TestNG |
| **Build Tool** | Maven |
| **Design Pattern** | Page Object Model (POM) |
| **Reporting** | Extent Reports + TestNG HTML |
| **Logging** | Log4j2 |
| **Data-Driven Testing** | Excel via Apache POI |
| **Parallel Execution** | TestNG + XML Suite |
| **CI/CD Ready** | Jenkins |
| **Cross-Browser Execution** | Selenium Grid / Docker |
| **Configuration Management** | config.properties |

---

## 📂 Project Structure

```
ParabankSKM/
 ├── pom.xml                     # Maven dependencies
 ├── testng.xml                  # Default suite configuration
 ├── Paralleltesting.xml         # Parallel test configuration
 ├── docker-compose.yaml         # Dockerized Selenium Grid setup
 ├── src/
 │   └── test/java/
 │        ├── pageObjects/       # Page classes (POM)
 │        ├── testBase/          # BaseClass for setup/teardown
 │        ├── testCases/         # Test scripts (TestNG)
 │        └── utilities/         # Utilities (reports, Excel, DataProvider)
 │
 ├── src/test/resources/
 │        ├── config.properties  # Environment configuration
 │        ├── log4j2.xml         # Logging configuration
 │        └── log4j2-back.xml    # Backup log configuration
 │
 ├── reports/                    # Extent Reports output (HTML)
 ├── screenshots/                # Failure screenshots
 ├── run.bat                     # Local execution batch file
 └── README.md                   # Project documentation
```

---

## 🚀 How to Run Tests

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Kaviya0624/ParabankSKM.git
cd ParabankSKM

💡 Note:
This framework was tested against the Parabank web application deployed locally using Apache Tomcat.
You can download the Parabank WAR file from the official source, deploy it on Tomcat
(e.g., http://localhost:8080/parabank), and then execute the automation suite against that local instance.

```


### 2️⃣ Install Dependencies
```bash
mvn clean install
```

### 3️⃣ Run Test Suite
Run all tests using TestNG:
```bash
mvn test
```

Run a specific suite:
```bash
mvn clean test -DsuiteXmlFile=Master.xml
```

### 4️⃣ Run Parallel Tests
```bash
mvn clean test -DsuiteXmlFile=Paralleltesting.xml
```

### 5️⃣ View Reports
After execution, open:
```
reports/ExtentReport.html
```

---

## 🧪 Key Test Scenarios

| Test Case ID | Test Scenario | Description |
|---------------|----------------|--------------|
| TC001 | Register | Validate new user registration |
| TC002 | Login | Verify login with valid credentials |
| TC003 | Open Account | Open new savings/checking account |
| TC004 | Transfer Funds | Validate internal fund transfer |
| TC005 | Bill Pay | Test bill payment functionality |
| TC006 | Apply Loan | Verify loan application workflow |
| TC007 | Login DDT | Login with multiple credentials (Excel) |
| TC008 | Home Page | Verify home page UI and navigation |
| TC009 | Footer | Validate footer links and content |
| TC010 | Accounts Overview | Validate account summary and balance |

---

## 🧰 Utilities

* `ExcelUtility.java` – Reads Excel data for DDT  
* `ExtentReportManager.java` – Handles Extent Report setup  
* `DataProviders.java` – Supplies data to TestNG via `@DataProvider`  
* `BaseClass.java` – Initializes WebDriver and config setup  
* `config.properties` – URL, credentials, and driver settings  

---

## ⚡ QA Best Practices Implemented

* Page Object Model (POM) for scalability  
* Data-driven testing (Excel)  
* Assertions for validation  
* Screenshots on failure  
* Parallel execution support  
* Logging via Log4j2  
* Extent + TestNG HTML reports  
* Selenium Grid integration for distributed testing  
* Docker setup for cross-browser execution  

---

## 🧱 Example Test Flow (E2E)

1. Launch browser and navigate to Parabank  
2. Register and login with valid credentials  
3. Open a new account  
4. Transfer funds between accounts  
5. Pay a bill  
6. Apply for a loan  
7. Verify transactions and logout  

---

## 🔮 Future Enhancements

* Integrate **Allure Reports** for advanced visualization  
* Introduce **API Testing** (RestAssured) for backend validation  

---

## 👨‍💻 About Me

Hi, I’m **Siva Kaviyamalya 👋** — an aspiring Automation Test Engineer passionate about building robust, scalable, and maintainable frameworks.

* 💡 Proficient in Java, Selenium, TestNG, Maven, Jenkins, Git, Extent Reports  
* 🚀 Skilled in automation framework design, POM structure, and parallel execution  
* 🔎 Interested in QA automation, CI/CD, and quality improvement initiatives  

---

## 📬 Contact

* 📧 Email: [kaviyamalya3000@gmail.com](mailto:kaviyamalya3000@gmail.com)
* 🔗 LinkedIn: [linkedin.com/in/kaviyamalya610](https://linkedin.com/in/kaviyamalya610)

---

## 🖼 Screenshots

### Test Execution Report


### Selenium Grid


### Jenkins Build


### Jenkins Build


---

## 🏷️ Badges

* Java 17+
* Selenium WebDriver
* TestNG 7.8
* Maven 3.9.0
* Extent Reports

---

> 🧩 *This project demonstrates a complete, modular, and industry-ready automation testing framework for functional, regression, and data-driven testing of web applications.*

