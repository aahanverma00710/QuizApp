package com.avcoding.data.repo

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.domain.repo.QuizQuestionRepo

class QuizQuestionRepoImpl : QuizQuestionRepo {
    private val quizQuestions = mutableListOf<QuizQuestions>()
    override fun upsertQuestion(question: QuizQuestions) {
        quizQuestions.add(question)
    }

    override fun getAllQuestions(
        topicCode: Int?,
        limit: Int?
    ): List<QuizQuestions> {
        return if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit?:quizQuestions.size)
        } else {
            quizQuestions
                .take(limit?: quizQuestions.size)
        }
    }

    override fun getQuestionById(id: String?): QuizQuestions? {
        return quizQuestions.find { it.id == id }
    }

    override fun deleteQuestionById(id: String): Boolean {
        return quizQuestions.removeIf { it.id == id }
    }
}