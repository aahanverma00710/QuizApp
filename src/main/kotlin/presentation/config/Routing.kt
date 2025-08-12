package com.avcoding.presentation.config

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.presentation.routes.quiz_questions.getAllQuizQuestions
import com.avcoding.presentation.routes.quiz_questions.upsertQuizQuestions
import com.avcoding.presentation.routes.root
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting(){
    routing {
        root()
        getAllQuizQuestions()
        upsertQuizQuestions()
    }
}
val quizQuestions = mutableListOf<QuizQuestions>()