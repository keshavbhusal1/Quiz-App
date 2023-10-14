package com.example.quizapp.ui.quiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.quizapp.AppCreator
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentQuizBinding
import com.example.quizapp.factory.ViewModelFactory
import com.example.quizapp.helper.Status

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var mQuizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
        initData()
        listDataFromServer()
    }

    private fun initData() {
        //initialization of viewmodel instance,
        mQuizViewModel = ViewModelProvider(
            this,
            ViewModelFactory(AppCreator.getApiHelperInstance())
        ).get(QuizViewModel::class.java)
    }

    private fun listDataFromServer() {
        mQuizViewModel.getQuestions(100).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("Response", "listDataFromServer: Success")
                }

                Status.FAILURE -> {
                    Log.d("Response", "listDataFromServer: Failure")
                }

                Status.LOADING -> {
                    Log.d("Response", "listDataFromServer: Loading")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}