package ehb.sv.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ehb.sv.databinding.FragmentQuestionFalseBinding


class QuestionFalseFragment : Fragment() {
    private lateinit var binding: FragmentQuestionFalseBinding
    private val args : QuestionFalseFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionFalseBinding.inflate(inflater, container, false)
        val data = args.question
        val number = args.questNumber

        binding.questionnumb.text = (number+1).toString()
        binding.correctAnswer.text = data[number].correctAnswer

        binding.button.setOnClickListener {
            val action = QuestionFalseFragmentDirections.actionQuestionFalseFragmentToQuestionFragment(data,number+1)
            findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}