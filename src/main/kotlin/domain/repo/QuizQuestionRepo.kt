package com.avcoding.domain.repo

import com.avcoding.domain.model.QuizQuestions

interface QuizQuestionRepo {
    suspend fun upsertQuestion(question: QuizQuestions)

    suspend fun getAllQuestions(topicCode: Int?,limit: Int?): List<QuizQuestions>

    suspend fun getQuestionById(id: String?): QuizQuestions?

    suspend fun deleteQuestionById(id: String): Boolean
}