package com.example.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.students.databinding.FragmentAddingBinding

class AddingFragment : Fragment() {
private lateinit var binding:FragmentAddingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddingBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addFaculty.setOnClickListener {
            findNavController().navigate(R.id.addFakultetsFragment)
             }
        binding.addGroup.setOnClickListener {
            findNavController().navigate(R.id.addGroupFragment)
        }
        binding.addStudents.setOnClickListener {
            findNavController().navigate(R.id.addStudentsFragment)
        }
        binding.toolbar.backBtn.setOnClickListener {
         findNavController().navigate(R.id.listFakultetFragment)
        }
        binding.toolbar.toolbarTxt.text="Добаление"
    }
}