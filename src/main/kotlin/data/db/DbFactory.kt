package com.avcoding.data.db

import com.avcoding.utils.Constants
import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object DbFactory {

    fun create() : MongoDatabase{
        val connectionString = System.getenv("MONGO_URI") ?: throw IllegalArgumentException("Mongo URI is not set")
        val dbName = Constants.MONGO_DB_NAME
        val client = MongoClient.create(connectionString)
        return client.getDatabase(dbName)
    }
}