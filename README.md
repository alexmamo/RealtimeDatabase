# RealtimeDatabase - Clean Architecture with MVVM.

It's an aplication build with Kotlin as an example on how to display data from a [Cloud Firestore](https://firebase.google.com/docs/firestore) database, using [Jetpack Compose](https://developer.android.com/jetpack/compose).

To keep things simple, the app uses a very simple database schema that look like in the image below:

![alt text](https://i.ibb.co/rkmLvqY/Db.jpg)

The app uses the [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) together with [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) in a MVVM Architecture Pattern. For dependency injection the app uses [Hilt for Android](https://developer.android.com/training/dependency-injection/hilt-android). 

To make this app work, follow the instructions given in the official documentation regarding [how to add Firebase to your project](https://firebase.google.com/docs/android/setup). Add the JSON file in your app folder, add some dummy products and see it working.

This repo is the source code of the this article: [How to display data from Firestore using Jetpack Compose?](https://medium.com/firebase-developers/how-to-display-data-from-firestore-using-jetpack-compose-49ee736dc07d)

See it also on youtube: https://www.youtube.com/watch?v=QaJFqRCoK1o&ab_channel=AlexMamo
