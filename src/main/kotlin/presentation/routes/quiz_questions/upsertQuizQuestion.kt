package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.presentation.config.quizQuestions
import io.ktor.server.request.receive
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.upsertQuizQuestions(){
    post(path = "/quiz/questions") {
        val questions = call.receive<QuizQuestions>()
        quizQuestions.add(questions)
        call.respondText("Question Added successfully")
    }
}