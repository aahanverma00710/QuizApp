package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.domain.repo.QuizQuestionRepo
import io.ktor.http.HttpStatusCode
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.response.*

fun Route.getQuizQuestionById( repo:QuizQuestionRepo) {
    get(path="/quiz/questions/{qId}"){
        val id =  call.parameters["qId"]
        if (id.isNullOrEmpty()){
            call.respond(
                message = "Question Id Needed",
                status = HttpStatusCode.BadRequest
            )
            return@get
        }
        val question: QuizQuestions? =  repo.getQuestionById(id)
        if (question != null){
            call.respond(message =  question,
                status = HttpStatusCode.OK)
        }else{
            call.respond(
                message = "Question not found",
                status = HttpStatusCode.BadRequest
            )
        }

    }
}