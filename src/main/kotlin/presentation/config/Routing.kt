package com.avcoding.presentation.config

import com.avcoding.data.repo.QuizQuestionRepoImpl
import com.avcoding.domain.model.QuizQuestions
import com.avcoding.domain.repo.QuizQuestionRepo
import com.avcoding.presentation.routes.quiz_questions.deleteQuizQuestionById
import com.avcoding.presentation.routes.quiz_questions.getAllQuizQuestions
import com.avcoding.presentation.routes.quiz_questions.getQuizQuestionById
import com.avcoding.presentation.routes.quiz_questions.upsertQuizQuestions
import com.avcoding.presentation.routes.root
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting(){
    val quizQuestionRepo : QuizQuestionRepo = QuizQuestionRepoImpl()
    routing {
        root()
        getAllQuizQuestions(quizQuestionRepo)
        upsertQuizQuestions(quizQuestionRepo)
        deleteQuizQuestionById(quizQuestionRepo)
        getQuizQuestionById(quizQuestionRepo)
    }
}
