
# 📘 Spring Boot Testing Project

This project demonstrates **unit testing** in a Spring Boot application using:

- ✅ **JUnit 5**
- ✅ **Mockito (classic and BDD style)**
- ✅ **AssertJ**
- ✅ **TDD/BDD principles**

---

## 🧪 What I Learned

### 🧷 JUnit 5
- Writing unit test cases using `@Test`
- Using lifecycle methods like `@BeforeEach` for setup
- Assertions with `Assertions.assertEquals`, `assertThrows`, etc.

### 🎭 Mockito
- Creating mock objects using `@Mock` and injecting them with `@InjectMocks`
- Stubbing method calls using `when(...).thenReturn(...)`
- Verifying method calls with `verify(...)`

### 🔄 BDD with Mockito (BDDMockito)
- Writing expressive tests using `given`, `when`, `then`
- Focusing on behavior over implementation
- More readable test cases for better collaboration

### ✅ AssertJ
- Writing fluent, readable assertions such as:
  ```java
  assertThat(book.getPrice()).isEqualTo(500);
  assertThat(bookList).hasSize(2).contains(book1);
````

---

## ✅ Sample Test Cases Covered

* Adding a book using mock repository
* Retrieving books and applying discounts
* Calculating total cost using mocked responses
* Verifying method interactions
* Handling exceptions with `assertThrows`
* Writing tests using BDD naming and structure

---

## 🧰 Technologies & Tools

* Java 17
* Spring Boot
* JUnit 5
* Mockito 3+
* AssertJ
* Maven
* IntelliJ IDEA

---

## 🔍 How to Run the Tests

```bash
# Run all tests using Maven
mvn test
```

---

## 🚀 Future Improvements

* Add integration tests using `@SpringBootTest`
* Include test coverage reports using Jacoco
* Add parameterized tests for edge cases

---

## 🧑‍💻 Author

**Aditi Singh**
Learning and applying unit testing with Spring Boot, JUnit, and Mockito.

```

---

