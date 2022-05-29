package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology",
          "postContent": "We help you grow in your profession and open new career horizons.
          
          Netology is four levels of education:

          🔹 For beginners who want to master an actual profession from scratch
          🔹 For professionals who seek to grow in their careers
          🔹 For managers who aim to strengthen leadership skills
          🔹 And for companies that need to train a team

          Marketing, design, programming, soft skills, MBA, project management, analytics and Data Science — choose what is closer to you and come to us for knowledge and growth.

          Change is always the right choice 👌
          http://netolo.gy/fEU
          8 (800) 301-39-69
          Varshavskoe shosse, 1, p. 6, 1st floor, office 105A, Moscow"
        }""".trimIndent())
        .setToken("fBnheoqDSMiyg7Baek2U1r:APA91bHg2J3hLkWWcNQ0K2u44kpC2_ovTfePBUdhEmjBVPl-zF2Vpu04-tc7pMX8ZvA2J5w-do8ugB5aBiKBpKt5W8WZ0If9PxKSiAklsZ_ZJILU8nffn0gsKNtJp_NAgE9t2ze7z0XK")
        .build()

    FirebaseMessaging.getInstance().send(message)
}
