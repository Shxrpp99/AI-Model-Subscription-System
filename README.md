# 🤖 AI Subscription Management System

## 📌 Overview

The AI Subscription Management System is a Java-based application developed using Object-Oriented Programming (OOP) concepts and a Graphical User Interface (GUI). The system is designed to manage AI model subscription plans for both individual users and teams.

It supports two types of plans:

* **Personal Plan** – For individual users with limited prompt usage
* **Pro Plan** – For teams with collaboration features and member slots

---

## 🎯 Features

* Add Personal and Pro subscription plans
* Store plans dynamically using ArrayList
* Manage prompt usage and quotas
* Add and remove team members (Pro Plan)
* Validate user inputs (index, values, etc.)
* GUI-based interaction using Java Swing
* Export and load data from file
* Identify plan type using `instanceof`

---

## 🧱 Technologies Used

* **Java** (OOP Concepts)
* **Java Swing** (GUI)
* **BlueJ IDE**
* **ArrayList (Collections Framework)**
* **File Handling / Serialization**
* **Draw.io** (for Class Diagram)

---

## 🏗️ Project Structure

```
AI-Subscription-Manager/
│
├── AIModel.java
├── PersonalPlan.java
├── ProPlan.java
├── SubscriptionGUI.java
└── README.md
```

---

## 📊 OOP Concepts Implemented

* **Encapsulation** – Private attributes with getter methods
* **Inheritance** – PersonalPlan and ProPlan extend AIModel
* **Polymorphism** – Method overriding (display method)
* **Abstraction** – General AIModel class structure

---

## 🖥️ How to Run

### Using BlueJ:

1. Open the project in BlueJ
2. Compile all classes
3. Run `SubscriptionGUI` class

### Using Terminal:

```
javac *.java
java SubscriptionGUI
```

---

## 🧪 Testing

The system has been tested for:

* Adding plans
* Making prompts
* Adding team members
* Handling invalid inputs
* File saving and loading

---

## ⚠️ Error Handling

* Invalid index handling using try-catch
* Input validation for prompts and slots
* Prevention of negative values

---

## 📚 Learning Outcomes

This project helped in understanding:

* Real-world application of OOP concepts
* GUI development using Swing
* File handling in Java
* Debugging and error handling

---

## 👨‍💻 Author

**Sohan Gurung**
🔗 LinkedIn: https://www.linkedin.com/in/sohan-gurung-60ab503b2/

---

## 📄 License

This project is for educational purposes.
