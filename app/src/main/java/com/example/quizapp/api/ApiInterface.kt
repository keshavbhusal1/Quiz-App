package com.example.quizapp.api

import com.example.quizapp.model.QuizModel
import com.example.quizapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(Constants.API)
    suspend fun getQuestions(@Query("amount") amount:Int):QuizModel
}