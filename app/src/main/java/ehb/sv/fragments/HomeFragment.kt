package ehb.sv.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ehb.sv.R
import ehb.sv.classes.QuestnItem
import ehb.sv.data.QuestRetriever
import ehb.sv.data.getQuestData
import ehb.sv.data.getQuestData_suspend
import ehb.sv.databinding.FragmentHomeBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import okhttp3.Dispatcher


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    lateinit var questiondata: Array<QuestnItem>
    lateinit var job: Job
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnstart.isEnabled = true
//        datajob()
        return binding.root
    }

//    suspend fun datajob() = runBlocking {
//        job = launch {
//            var data  = getQuestData_suspend()
//            if (data != null) {
//                questiondata = data.toTypedArray()
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
//        binding.btnstart.isEnabled = job.isCompleted
//        binding.btnstart.setOnClickListener{
////            var data = fetchQuestions()
//            val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment(questiondata, 1)
//            findNavController().navigate(action)
//        }
//    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.btnstart.isEnabled = this::questiondata.isInitialized
        binding.btnstart.isEnabled = true

        binding.btnstart.setOnClickListener{
//            var data = fetchQuestions()
            questiondata = emptyArray()
            val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment(questiondata, 2)
            findNavController().navigate(action)

//            var data : List<QuestnItem> = emptyList()
//            CoroutineScope(Dispatchers.IO).launch {
//                val response = getQuestData()
//                withContext(Dispatchers.Main) {
//                    var data = response
//                    val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment(response.toTypedArray(), 1)
// //           findNavController().navigate(R.id.action_homeFragment_to_questionFragment)
//                    findNavController().navigate(action)
//
//                }
//            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


}