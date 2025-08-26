package com.avcoding.domain.repo

import com.avcoding.domain.model.QuizQuestions

interface QuizQuestionRepo {
    fun upsertQuestion(question: QuizQuestions)

    fun getAllQuestions(topicCode: Int?,limit: Int?): List<QuizQuestions>

    fun getQuestionById(id: String?): QuizQuestions?

    fun deleteQuestionById(id: String): Boolean
}