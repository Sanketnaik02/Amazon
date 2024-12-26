# Amazon E-Commerce Automation Framework

## Overview
This repository contains an Automation Framework designed to test the key functionalities of the Amazon E-commerce website. The framework is built to ensure robust testing and reliability for the following features:

1. **Cart Functionality**
2. **Login & Registration**
3. **Product Page**
4. **Search & Filtering**

## Features
- Comprehensive test coverage for Amazon's essential user workflows.
- Easy-to-maintain test scripts with reusable components.
- Modular and scalable structure to support additional functionality testing.
- Detailed reporting to track test results and failures.

## Prerequisites
- **Programming Language**: Java
- **Framework Used**: Selenium.
- **Tools**:
  - WebDriver/Browser Automation Tool
  - TestNG
  - Dependency manager (e.g., Maven, Gradle, npm)
- **Browsers Supported**: Chrome, Firefox, Edge

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/Sanketnaik02/Amazon.git
   ```
2. Navigate to the project directory:
   ```bash
   cd <repository-name>
   ```
3. Install dependencies:
   ```bash
   # For Java (Maven example):
   mvn install


## Test Scenarios

### 1. **Cart Functionality**
- Add items to the cart
- Remove items from the cart
- Update item quantities
- Verify cart totals

### 2. **Login & Registration**
- Register a new user account
- Login with valid credentials
- Handle login errors for invalid credentials
- Logout functionality

### 3. **Product Page**
- Verify product details (name, description, price, etc.)
- Test "Add to Wishlist" feature
- Navigate between product images

### 4. **Search & Filtering**
- Search for products using keywords
- Apply filters and verify results
- Sort products by price, rating, etc.

## Running Tests

### Using Command Line
1. Run all tests:
   ```bash
   # For Java (Maven):
   mvn test

2. Run specific tests:
   ```bash
   # For Java (Maven):
   mvn test -Dtest=TestClassName


### Using IDE
- Open the project in your preferred IDE (e.g., IntelliJ IDEA, PyCharm, VS Code).
- Navigate to the test files and execute the tests.

## Test Reports
- Detailed reports are generated after each test execution.
- Reports are located in the following directory:
  ```
  <project-directory>/test-reports
  ```
- Open the report in a browser to view the test summary and detailed logs.

## Contribution
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Make your changes and commit:
   ```bash
   git commit -m "Add your message here"
   ```
4. Push the changes to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Create a Pull Request.


## Contact
For any inquiries, feel free to reach out:
- **Email**: sanketnaik393@gmail.com
- **GitHub**: https://github.com/Sanketnaik02/





