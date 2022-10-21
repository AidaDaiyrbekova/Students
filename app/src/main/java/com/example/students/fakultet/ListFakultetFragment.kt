package com.example.students.fakultet

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.students.App
import com.example.students.adapters.FacultyAdapter
import com.example.students.databinding.FragmentListFakultetBinding

class ListFakultetFragment : Fragment() {

    private lateinit var binding: FragmentListFakultetBinding
      override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding= FragmentListFakultetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbCategory = App.instance?.getDatabase()?.FakultetDao()
        val recyclerView = binding.categorySelectRecyclerview
        recyclerView.adapter = FacultyAdapter(dbCategory!!.getAllCategory(), requireActivity())
        binding.toolbar.txt.text="Главная"


    }

}