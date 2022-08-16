package ehb.sv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import ehb.sv.classes.User
import ehb.sv.data.UserDatabase
import ehb.sv.data.UserRepository
import ehb.sv.databinding.ActivityUserBinding
import ehb.sv.databinding.FragmentUserBinding
import ehb.sv.fragments.UserFragmentDirections
import kotlinx.coroutines.*

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    lateinit var repos: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        repos = UserRepository(UserDatabase.getDatabase(this.applicationContext).userDao())
        setupActionBarWithNavController(findNavController(R.id.fragmentContainer))

        stuff()
        binding.saveName.setOnClickListener {
            updateUser()
        }
    }

    fun stuff(){
        val observer = Observer<List<User>>{
                users ->
            if(users.size==0){
                createUser()
            } else{
                binding.username.text = users[0].name
                binding.amountCorrect.text = "Correct questions: "+users[0].questCorrect.toString()
                binding.amountWrong.text = "Wrong questions: "+users[0].questWrong.toString()
            }
            println(users)
        }
        var list = repos.getAll.asLiveData()
        list.observe(this, observer)
    }

    fun updateUser(){
        val questFetchJob = Job()
        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Error -Q72- could not save user: "+ throwable.message)
        }
        val scope = CoroutineScope(questFetchJob + Dispatchers.Main)

        scope.launch(errorHandler){
            repos.update(User(1, binding.username.text.toString()))
        }
    }
    fun createUser(){
        val questFetchJob = Job()
        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Error -Q72- could not save user: "+ throwable.message)
        }
        val scope = CoroutineScope(questFetchJob + Dispatchers.Main)

        scope.launch(errorHandler){
            repos.insert(User(1))
        }
    }
}