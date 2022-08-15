package ehb.sv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ehb.sv.databinding.FragmentQuestionCorrectBinding
import ehb.sv.databinding.FragmentQuestionFalseBinding

class QuestionCorrectFragment : Fragment() {

    private lateinit var binding: FragmentQuestionCorrectBinding
    private val args : QuestionCorrectFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionCorrectBinding.inflate(inflater, container, false)
        val data = args.question
        val number = args.questNumber

        binding.questionnumb.text = (number+1).toString()

        binding.button.setOnClickListener {
            val action = QuestionCorrectFragmentDirections.actionQuestionCorrectFragmentToQuestionFragment(data, number+1)
            findNavController().navigate(action)
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}