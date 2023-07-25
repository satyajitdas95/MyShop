## MyShop - Sample E-commerce App

[//]: # (<p align="center">)

[//]: # (  <img src="https://dassatya1995.github.io/NewsX-1.jpeg" height="500" width="250">)

[//]: # (  <img src="https://dassatya1995.github.io/NewsX-2.jpeg" height="500" width="250">)

[//]: # (  <img src="https://dassatya1995.github.io/NewsX-3.gif" height="500" width="250">)

[//]: # (</p>)

[//]: # (<br>)

[//]: # (***You can Install and test latest app from below 👇***)

[//]: # ()
[//]: # ([![NewsX App]&#40;https://img.shields.io/badge/NewsX-Apk-blue?style=for-the-badge&logo=android&#41;]&#40;https://github.com/dassatya1995/NewsX/releases/download/NewsX/NewsX.apk&#41;)

## About
A Simple E-Commerce app demow ith local db and search feature. 

- MVVM architecture
- Clean and Simple Material UI.
- [Dummyjson.com](https://dummyjson.com/) API is used in this app.

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - Programming language for Android development.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - For Ui Components
- [Coroutine](https://developer.android.com/kotlin/coroutines) - For asynchronous and more..
- [Flow](https://developer.android.com/kotlin/flow) - For stream data that asynchronously
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes.
    - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to more easily write code that interacts with views.
    - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
- [Dependency Injection](https://developer.android.com/training/dependency-injection) -
    - [Dagger2](https://dagger.dev/) - Standard library to incorporate Dagger dependency injection into an Android application.
- [Retrofit](https://github.com/amitshekhariitbhu/Fast-Android-Networking) - A Complete Fast Android Networking Library that also supports HTTP/2.
- [Gson](https://github.com/google/gson) - A modern JSON library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android focused on smooth scrolling.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.


# Package Structure

    com.newsorg.newsapp.android    # Root Package
    .
    ├── data                # For data handling.
    │   ├── local           # Local Persistence Database. Room  and shared perf
    |   │   ├── dao         # Data Access Object for Room   
    |   |   └── perf        # Shared preferences
    │   ├── remote          # Remote Data Handlers     
    │   ├── model           # Model classes
    |   │   ├── api         # Model classes for Api
    |   |   └── db          # Model classes for Db
    │   └── repository      # Single source of data.
    |
    ├── di                  # Dependency Injection  
    │   ├── module          # DI Modules
    │   ├── component       # DI Components       
    │   └── scope           # Dependency Scope
    |
    ├── ui                  # Activity/View layer
    │   ├── base            # Base View
    │   ├── article_feed          # Main Screen Activity & ViewModel
    |   │   ├── adapter     # Adapter for RecyclerView
    |   │   └── viewmodel   # ViewHolder for RecyclerView   
    │   └── article_details       # Detail Screen Activity and ViewModel
    |
    └── utils               # Utility Classes 


## Architecture
This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture.

![](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

### Requirements
- JDK 8
- Latest Android SDK tools
- Latest Android platform tools
- Android SDK 21 or newer
- AndroidX

#### Setup Project
1. Open Android studio and select Get from Version Control.
2. Add URL as **https://github.com/satyajitdas95/MyShop** and proceed.
3. Sync The project and you are done.




## License
```
MIT License

Copyright (c) 2021 Satyajit Das

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
