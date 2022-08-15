package ehb.sv

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import ehb.sv.classes.QuestItem
import ehb.sv.classes.Questn
import ehb.sv.classes.QuestnItem
import ehb.sv.data.ApiInterface
import ehb.sv.databinding.ActivityMainBinding
import ehb.sv.fragments.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder
import ehb.sv.data.getQuestData

//const val BASE_URL = "https://www.opentdb.com/"
const val BASE_URL = " https://the-trivia-api.com/api/"

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.fragmentContainer))
//        replaceFragment(HomeFragment())

//        var data = getQuestData()
//        binding.btnStart.setOnClickListener {
//            startActivity(Intent(this, QuestionActivity::class.java)
//                .putExtra("number", 20))
//        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragManager = supportFragmentManager
        val fragTransaction = fragManager.beginTransaction()
        fragTransaction.replace(R.id.fragmentContainer, fragment)
        fragTransaction.commit()

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainer)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(baseContext, "Landscape Mode", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(baseContext, "Portrait Mode", Toast.LENGTH_SHORT).show()
        }
    }
}