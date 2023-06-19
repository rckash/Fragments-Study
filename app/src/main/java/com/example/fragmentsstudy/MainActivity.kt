package com.example.fragmentsstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.fragmentsstudy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //text to be passed to the fragment
        var mainText = "This is a text from Main Activity"

        //create objects from Fragments
        val f1 = FragmentOne()
        val f2 = FragmentTwo()
        val f3 = FragmentThree()

        //default fragment
        supportFragmentManager.beginTransaction().apply {
            var myBundle = Bundle()
            myBundle.putString("mainText", mainText)
            f1.arguments = myBundle
            replace(R.id.fragmentContainerView, f1)
            commit()
        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        var myBundle = Bundle()
                        myBundle.putString("mainText", mainText)
                        f1.arguments = myBundle
                        replace(R.id.fragmentContainerView, f1)
                        commit()
                    }
                }
                R.id.menu_profile -> {
                    supportFragmentManager.beginTransaction().apply {
                        var myBundle = Bundle()
                        myBundle.putString("mainText", mainText)
                        f2.arguments = myBundle
                        replace(R.id.fragmentContainerView, f2)
                        commit()
                    }
                }
                R.id.menu_notification -> {
                    supportFragmentManager.beginTransaction().apply {
                        var myBundle = Bundle()
                        myBundle.putString("mainText", mainText)
                        f3.arguments = myBundle
                        replace(R.id.fragmentContainerView, f3)
                        commit()
                    }
                }
            }
            true
        }

//        binding.btnFragmentOne.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragmentContainerView, f1)
//                commit()
//            }
//        }
//        binding.btnFragmentTwo.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragmentContainerView, f2)
//                commit()
//            }
//        }
    }
}