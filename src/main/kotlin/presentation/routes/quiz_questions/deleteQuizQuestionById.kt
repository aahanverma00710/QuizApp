package com.avcoding.presentation.routes.quiz_questions

import com.avcoding.domain.repo.QuizQuestionRepo
import io.ktor.http.HttpStatusCode
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete

fun Route.deleteQuizQuestionById(
    repo:QuizQuestionRepo
){
    delete(path="/quiz/questions/{qId}"){
       val id =  call.parameters["qId"]
        if (id.isNullOrEmpty()){
            call.respond(
                message = "Question Id Needed",
                status = HttpStatusCode.BadRequest
            )
            return@delete
        }
        val isDeleted = repo.deleteQuestionById(id)
        if (isDeleted){
            call.respond(message =  "Deleted Successfully",
                status = HttpStatusCode.NoContent)
        }else{
            call.respond(
                message = "Question not found",
                status = HttpStatusCode.BadRequest
            )
        }

    }
}