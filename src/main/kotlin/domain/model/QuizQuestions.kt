package com.avcoding.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class QuizQuestions(
    val id: String?=null,
    val question : String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val explanations: String,
    val topicCode : Int
)
