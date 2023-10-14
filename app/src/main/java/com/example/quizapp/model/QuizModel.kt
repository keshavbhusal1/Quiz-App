package com.example.quizapp.model


import com.google.gson.annotations.SerializedName

data class QuizModel(
    @SerializedName("response_code")
    val responseCode: Int, // 0
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("category")
        val category: String, // Entertainment: Cartoon & Animations
        @SerializedName("correct_answer")
        val correctAnswer: String, // Scoobert
        @SerializedName("difficulty")
        val difficulty: String, // medium
        @SerializedName("incorrect_answers")
        val incorrectAnswers: List<String>,
        @SerializedName("question")
        val question: String, // What is Scooby-Doo&#039;s real name?
        @SerializedName("type")
        val type: String // multiple
    )
}