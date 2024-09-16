package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("nmedia-b3264-firebase-adminsdk-h05v6-955e8d7304.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val messageLike = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messageSavePost = Message.builder()
        .putData("action", "SAVE_POST")
        .putData("content", """{
          "author": "Vasiliy",
          "content": "Hello World!"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(messageLike)
    FirebaseMessaging.getInstance().send(messageSavePost)
}
