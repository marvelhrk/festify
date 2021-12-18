package com.iiitlucknow.festify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iiitlucknow.festify.Adapters.recyclerAdapter
import com.iiitlucknow.festify.Adapters.sliderAdapter
import com.iiitlucknow.festify.data.recyclerItem
import com.iiitlucknow.festify.databinding.ActivityMainBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val navController = findNavController(R.id.fragmenthost)
//        binding.bottomNavigationBar.setupWithNavController(navController)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmenthost) as NavHostFragment
        binding.bottomNavigationBar.setupWithNavController(navHostFragment.navController)

        supportActionBar?.hide()
    }
}
