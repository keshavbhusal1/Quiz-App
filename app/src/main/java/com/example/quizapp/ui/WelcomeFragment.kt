package com.example.quizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.quizapp.R
import com.example.quizapp.Username
import com.example.quizapp.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            if (binding.filledTextField.editText?.text.toString().trim().isEmpty()){
                binding.filledTextField.isErrorEnabled = true
                binding.filledTextField.error = "Enter User name"
            }else{
                Username.saveUsername(binding.filledTextField.editText?.text.toString())
                findNavController().navigate(R.id.action_WelcomeFragment_to_QuizFragment)
            }
        }

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_WelcomeFragment_to_QuizFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}