package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.domain.repo.QuizQuestionRepo
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.upsertQuizQuestions( repo:QuizQuestionRepo){
    post(path = "/quiz/questions") {
        val questions = call.receive<QuizQuestions>()
        repo.upsertQuestion(questions)
        call.respond(message = "Question Added successfully",
            status = HttpStatusCode.Created)
    }
}