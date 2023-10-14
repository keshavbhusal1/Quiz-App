package com.example.quizapp.repo

import com.example.quizapp.helper.ApiHelper

class QuizRepo(private val apiHelper: ApiHelper) {

    suspend fun getQuestions(amount:Int) = apiHelper.getQuestions(amount)

}