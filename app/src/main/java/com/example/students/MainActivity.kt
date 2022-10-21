package com.example.students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.students.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBottomNav()
    }
        private fun setBottomNav(){
            val navController = findNavController(R.id.fragment_container_main)
            binding.addBtn.setOnClickListener {
                navController.popBackStack(R.id.addingFragment,true)
                navController.navigate(R.id.addingFragment)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.listFakultetFragment -> showBottomNav()
                    R.id.listGroupFragment -> showBottomNav()
                    R.id.listStudentFragment -> showBottomNav()
                    else -> hideBottomNav()
                }

            }
        }
        private fun showBottomNav() {
            binding.addBtn.visibility = View.VISIBLE
        }
        private fun hideBottomNav() {
            binding.addBtn.visibility = View.GONE
        }
    }