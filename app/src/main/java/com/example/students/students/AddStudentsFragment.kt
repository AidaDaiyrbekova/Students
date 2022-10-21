package com.example.students.students

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.example.students.App
import com.example.students.R
import com.example.students.databinding.FragmentAddStudentsBinding
import com.example.students.db.Students


class AddStudentsFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentAddStudentsBinding
    var groupsId:Int?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddStudentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbStudents = App.instance?.getDatabase()?.StudentsDao()
        val dbGroup = App.instance?.getDatabase()?.GroupsDao()
        val groupName = dbGroup?.getNameGroup()
        binding.toolbar.toolbarTxt.text="Добавление студента"
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(R.id.addingFragment)
        }
        spinnerCategory(binding.chooseCategorySpinner, groupName!!.toList())
        binding.chooseCategorySpinner.onItemSelectedListener = this

        binding.saveStudentBtn.setOnClickListener {
            dbStudents?.addStudent(Students(
                idStudents = null,
                sName = binding.addSurName.text.toString(),
                name=binding.addName.text.toString(),
                patronymic=binding.patronymic.text.toString(),
                dBd =binding.addBD.text.toString(),
                fkGroup = groupsId
            )
            )
            findNavController().navigate(R.id.addingFragment)

        }

    }
    fun spinnerCategory(spinner: Spinner, list: List<String>){
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    override fun onItemSelected(item: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val category = App.instance?.getDatabase()?.GroupsDao()?.getAllGroup()
        for (i in category!!){
            if (item?.selectedItem == i.nameGroup){
                groupsId = i.idGroup
            }
        }
    }

    override fun onNothingSelected(item: AdapterView<*>?) {
    }
}