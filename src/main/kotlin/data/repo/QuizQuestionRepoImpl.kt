package com.avcoding.data.repo

import com.avcoding.domain.model.QuizQuestions
import com.avcoding.domain.repo.QuizQuestionRepo
import com.avcoding.utils.Constants
import com.mongodb.kotlin.client.coroutine.MongoDatabase

class QuizQuestionRepoImpl(private val mongoDb: MongoDatabase) : QuizQuestionRepo {

    private val quizQuestion = mongoDb.getCollection<QuizQuestions>(Constants.QUIZ_COLLECTION_NAME)

    private val quizQuestions = mutableListOf<QuizQuestions>()

    override suspend fun upsertQuestion(question: QuizQuestions) {
        quizQuestion.insertOne(question)
    }

    override suspend fun getAllQuestions(
        topicCode: Int?,
        limit: Int?
    ): List<QuizQuestions> {
        return if (topicCode != null) {
            quizQuestions
                .filter { it.topicCode == topicCode }
                .take(limit ?: quizQuestions.size)
        } else {
            quizQuestions
                .take(limit ?: quizQuestions.size)
        }
    }

    override suspend fun getQuestionById(id: String?): QuizQuestions? {
        return quizQuestions.find { it.id == id }
    }

    override suspend fun deleteQuestionById(id: String): Boolean {
        return quizQuestions.removeIf { it.id == id }
    }
}