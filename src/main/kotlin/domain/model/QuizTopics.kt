package com.avcoding.domain.model

data  class QuizTopics(
    val id: String ?= null,
    val name: String,
    val imageUrl : String,
    val code: Int
)