package com.example.quizapp.ui.quiz

import androidx.lifecycle.liveData
import com.example.quizapp.repo.QuizRepo
import com.example.quizapp.helper.Resource
import androidx.lifecycle.ViewModel

class QuizViewModel(private val mQuizRepo: QuizRepo) : ViewModel() {

    fun getQuestions(amount: Int) = liveData {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(mQuizRepo.getQuestions(amount)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.message.toString()))
        }
    }

}