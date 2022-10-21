package com.example.students.fakultet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.students.App
import com.example.students.R
import com.example.students.databinding.FragmentAddFakultetsBinding
import com.example.students.db.Fakultet


class AddFakultetsFragment : Fragment() {
    private lateinit var binding: FragmentAddFakultetsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddFakultetsBinding.inflate(inflater, container, false)
         return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = App.instance?.getDatabase()?.FakultetDao()
        binding.saveFakultetBtn.setOnClickListener {
            db?.addCategory(
                Fakultet(
                    idFakultet = null,
                    nameFakultet = binding.addFacultyEt.text.toString()
                ))
            Log.d("DDDD", "${ db?.getId() }")
            binding.addFacultyEt.text.clear()
            findNavController().navigate(R.id.addingFragment)
        }
        binding.toolbar.toolbarTxt.text="Добавить факультет"
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(R.id.addingFragment)
        }
    }
}