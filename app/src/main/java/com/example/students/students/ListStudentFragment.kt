package com.example.students.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.students.App
import com.example.students.R
import com.example.students.adapters.StudentsAdapter
import com.example.students.databinding.FragmentListStudentBinding

class ListStudentFragment : Fragment() {
    private lateinit var binding: FragmentListStudentBinding
    private val args: ListStudentFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentListStudentBinding.inflate(inflater,container,false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val services = App.instance?.getDatabase()?.StudentsDao()?.getAllStudent()
        var filteredArray = services?.filter { it.fkGroup == args.groupId } as ArrayList
        val recyclerView = binding.categorySelectRecyclerview
        recyclerView.adapter = StudentsAdapter(filteredArray, requireActivity())
        binding.toolbar.toolbarTxt.text="Список студентов"
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(R.id.listGroupFragment)
        }
    }
}