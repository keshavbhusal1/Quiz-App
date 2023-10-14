package com.example.quizapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.helper.ApiHelper
import com.example.quizapp.repo.QuizRepo
import com.example.quizapp.ui.quiz.QuizViewModel
import java.lang.IllegalArgumentException
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(QuizViewModel::class.java)){
            return QuizViewModel(QuizRepo(apiHelper)) as T
        }
        throw IllegalArgumentException("Class not found")
    }
}