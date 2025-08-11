package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.model.QuizQuestions
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.getAllQuizQuestions(){
    get("/quiz/questions"){
        val sampleQuestion = QuizQuestions(
            id = "Q1",
            question = "What is the closest planet to the Sun?",
            correctAnswer = "Mercury",
            incorrectAnswers = listOf("Venus", "Earth", "Mars"),
            explanations = "Mercury is the closest planet to the Sun, orbiting at an average distance of about 57.9 million kilometers.",
            topicCode = 101
        )

        call.respondText(sampleQuestion.toString())
    }
}