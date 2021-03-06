# RealtimeDatabase - Clean Architecture with MVVM.

It's an aplication build with Kotlin as an example on how to display data from a [Fireabse Realtime Database](https://firebase.google.com/docs/firestore), using three different approaches. The first approach is using a callback, the second approach is using an [Android Architecture Component](https://developer.android.com/topic/libraries/architecture) called [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), and the third one is using [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html). All three approaches are using the same Android Architecture Component called [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel).

To keep things simple, the app uses a very simple database schema that look like in the image below:

![alt text](https://i.ibb.co/syqzxcZ/1.jpg)

To make this app work, follow the instructions given in the official documentation regarding [how to add Firebase to your project](https://firebase.google.com/docs/android/setup). Add the JSON file in your app folder, add some dummy products and see it working.

This repo is the source code of the this article: [How to read data from Firebase Realtime Database using get()?](https://medium.com/firebase-tips-tricks/how-to-read-data-from-firebase-realtime-database-using-get-269ef3e179c5)

See it also on youtube: https://youtu.be/mOB40wowo6Y
