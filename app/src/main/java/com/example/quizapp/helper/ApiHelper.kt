package com.example.quizapp.helper

import com.example.quizapp.api.ApiInterface


class ApiHelper (private val apiInterface: ApiInterface) {
    suspend fun getQuestions(amount:Int) = apiInterface.getQuestions(amount)
}