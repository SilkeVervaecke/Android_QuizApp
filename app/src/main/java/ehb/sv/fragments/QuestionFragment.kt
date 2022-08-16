package ehb.sv.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ehb.sv.classes.QuestnItem
import ehb.sv.data.QuestRetriever
import ehb.sv.data.UserDatabase
import ehb.sv.databinding.FragmentQuestionBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
//    val database by lazy { UserDatabase.getDatabase(this) }
    private val args : QuestionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        val data = args.question
        val number = args.questNumber
        println(args.question)
        println("** - **")
        if(data.size>0 && number<10){
            bind(data, number)
        }
        else{
            println("datasize: "+data.size+". number: "+number)
            fetchQuestions()
        }
        return binding.root
    }

    fun bind(data: Array<QuestnItem>, number: Int = 0){
        println(" -- we are binding -- ")
        binding.questionnumb.text = (number+1).toString()
        var quest = data[number]
        binding.textQuestion.text = quest.question

        val buttons = arrayOf(binding.answ1, binding.answ2, binding.answ3, binding.answ4)

        buttons.shuffle()
        buttons[0].text = quest.correctAnswer
        buttons[1].text = quest.incorrectAnswers[0]
        buttons[2].text = quest.incorrectAnswers[1]
        buttons[3].text = quest.incorrectAnswers[2]

        buttons[0].setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionCorrectFragment(data, number)
            findNavController().navigate(action)
        }
        buttons[1].setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionFalseFragment(data,number)
            findNavController().navigate(action)
        }
        buttons[2].setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionFalseFragment(data, number)
            findNavController().navigate(action)
        }
        buttons[3].setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionFalseFragment(data, number)
            findNavController().navigate(action)
        }
    }

    private fun fetchQuestions() {
        val questFetchJob = Job()
        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Error -Q114- could not get questions: "+ throwable.message)
//            Toast.makeText(this, "err", Toast.LENGTH_SHORT)
        }
        val scope = CoroutineScope(questFetchJob + Dispatchers.Main)

        scope.launch(errorHandler){
            println(" -- we are launching (Q120) -- ")
            var questions = QuestRetriever.getQuestions()
            println(questions)
            questions.enqueue(object : Callback<List<QuestnItem>?> {
                override fun onResponse(
                    call: Call<List<QuestnItem>?>,
                    response: Response<List<QuestnItem>?>
                ) {
                    println(response)
                    val responseBody = response.body()!!
                    bind(responseBody.toTypedArray(), 0)
                }

                override fun onFailure(call: Call<List<QuestnItem>?>, t: Throwable) {
                    println("API call gives error: "+t.message)
                    Log.d("API call for questions", "on Failure: " + t.message)
                }
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}