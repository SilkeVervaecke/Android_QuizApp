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
import ehb.sv.databinding.FragmentQuestionBinding
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class QuestionFragment : Fragment() {
    private lateinit var binding: FragmentQuestionBinding
//    lateinit var job: Job

    private val args : QuestionFragmentArgs by navArgs()
//    private val args by navArgs<QuestionFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        val data = args.question
        val number = args.questNumber
        println(args.question)
//        for (qu in args.question){
//            println(qu)
//        }
        println("** - **")
        if(data.size>0 && number<10){
            bind(data, number)
        }
        else{
            println("datasize: "+data.size+". number: "+number)
            fetchQuestions()
        }

//        println(data.size.toString() + " data " + data)
//        if (data.isEmpty()) {
//            binding.textQuestion.text = getString(R.string.question)
//            binding.answ1.text = getString(R.string.correctAnswer)
//            binding.answ2.text = getString(R.string.wrongAnswer1)
//            binding.answ3.text = getString(R.string.wrongAnswer2)
//            binding.answ4.text = getString(R.string.wrongAnswer3)
//            fetchQuestions()
//        }
//        else {
//            bind(data.toList())
//            var quest = data[0]
//            binding.textQuestion.text = quest.question
//            binding.answ1.text = quest.correctAnswer
//            binding.answ2.text = quest.incorrectAnswers[0]
//            binding.answ3.text = quest.incorrectAnswers[1]
//            binding.answ4.text = quest.incorrectAnswers[2]
//        }
// /       datajob()




        return binding.root
    }

//    fun datajob() = runBlocking {
//        var job = launch {
//            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
//
//            var data  = getQuestData_suspend()
//            if (data != null) {
//                bind(data)
//            } else{
//                println("data is null")
//            }
//            println("in the job: "+questiondata)
//            if (questiondata.size==0){
//                println("size is zero")
//            }else{
//                questiondata[0]
//            }
//        }
//        job.join()
//        println("job is done?!?")
//        if (questiondata.size==0){
//            println("size is zero")
//        }else{
//            questiondata[0]
//        }
//        println("job completed?: "+job.isCompleted)
//        println("job active?: "+job.isActive)
//        println("job cancelled?: "+job.isCancelled)
//
//    }

    fun bind(data: Array<QuestnItem>, number: Int = 0){
        println(" -- we are binding -- ")
        binding.questionnumb.text = (number+1).toString()
        var quest = data[number]
        binding.textQuestion.text = quest.question
        binding.answ1.text = quest.correctAnswer
        binding.answ2.text = quest.incorrectAnswers[0]
        binding.answ3.text = quest.incorrectAnswers[1]
        binding.answ4.text = quest.incorrectAnswers[2]
        binding.answ1
        binding.answ1.setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionCorrectFragment(data, number)
            findNavController().navigate(action)
        }
        binding.answ2.setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionFalseFragment(data,number)
            findNavController().navigate(action)
        }
        binding.answ3.setOnClickListener{
            val action = QuestionFragmentDirections.actionQuestionFragmentToQuestionFalseFragment(data, number)
            findNavController().navigate(action)
        }
        binding.answ4.setOnClickListener{
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

//        for (answ in question.incorrectAnswers){
//            binding.
//        }


    }

}