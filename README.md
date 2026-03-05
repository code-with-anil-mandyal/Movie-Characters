# Harry Potter Characters App 🧙‍♂️

This project is an Android application that displays a list of Harry Potter characters using the public API:  
https://hp-api.onrender.com/api/characters

The main goal of this project is to demonstrate a modern Android development approach using Clean Architecture, MVVM, and Jetpack Compose while following SOLID principles and best practices for scalable and maintainable code.

## 🚀 Features
- Fetches Harry Potter characters from a public API
- Displays character information in a clean and responsive UI
- Modern UI built completely with Jetpack Compose
- Structured using Clean Architecture for better separation of concerns
- Handles network calls efficiently using Kotlin Coroutines
- Dependency injection implemented using Dagger Hilt
- Uses Retrofit for REST API communication

## 🧱 Architecture
This project follows Clean Architecture with MVVM to keep the codebase modular, testable, and maintainable.

The architecture layers include:

- Presentation Layer
  - Jetpack Compose UI
  - ViewModels
  - UI state management

- Domain Layer
  - Use cases
  - Business logic

- Data Layer
  - Repository implementation
  - Retrofit API service
  - Data models and DTOs

This separation ensures the UI remains independent from data sources and business logic.

## 🛠 Tech Stack
- Kotlin
- Jetpack Compose
- MVVM Architecture
- Clean Architecture
- Retrofit
- Kotlin Coroutines
- Dagger Hilt (Dependency Injection)
- SOLID Principles

## 🌐 API
Data is fetched from the public Harry Potter API:

https://hp-api.onrender.com/api/characters

The API provides information about characters such as:
- Name
- Image
- House
- Actor
- Species
- Gender
- Date of birth

## 📂 Project Purpose
This project is created to demonstrate modern Android development practices and showcase how to structure a scalable Android application using Clean Architecture and MVVM.

It can be useful for:
- Learning modern Android development
- Understanding Clean Architecture implementation
- Reference for building production-ready Android apps

## 👨‍💻 Author
Anil Kumar
