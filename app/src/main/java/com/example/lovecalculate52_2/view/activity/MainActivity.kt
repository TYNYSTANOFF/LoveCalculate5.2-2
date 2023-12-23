package com.example.lovecalculate52_2.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculate52_2.Prefs
import com.example.lovecalculate52_2.R
import com.example.lovecalculate52_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    var prefs: Prefs? = null
        @Inject set


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)




        if (prefs!!.isShow()){
            prefs!!.saveState()

        }else{
            navController.navigate(R.id.parameterFragment)
        }
navController.addOnDestinationChangedListener{
        controller, destination, arguments ->
    val fragment = arrayListOf(
        R.id.parameterFragment,
        R.id.resultFragment,
        R.id.historyFragment
    )
    if (destination.id == R.id.boardFragment) {
        supportActionBar?.hide()
    } else {
        supportActionBar?.show()
    }

}
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }

}