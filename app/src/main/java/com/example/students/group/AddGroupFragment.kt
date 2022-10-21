package com.example.students.group

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
import com.example.students.databinding.FragmentAddGroupBinding
import com.example.students.db.Groups

class AddGroupFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: FragmentAddGroupBinding
   var facultyId:Int?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddGroupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbGroups = App.instance?.getDatabase()?.GroupsDao()
        val dbFaculty = App.instance?.getDatabase()?.FakultetDao()
        val facultyName = dbFaculty?.getNameCategory()

        spinnerCategory(binding.chooseCategorySpinner, facultyName!!)
        binding.chooseCategorySpinner.onItemSelectedListener = this

        binding.saveGroupBtn.setOnClickListener {
            dbGroups?.addGroup(
                Groups(
                idGroup = null,
                nameGroup = binding.addGroup.text.toString(),
                fkFakultet = facultyId
            )
            )
            findNavController().navigate(R.id.addingFragment)

        }
binding.toolbar.toolbarTxt.text="Добавление групп"
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(R.id.addingFragment)
        }
        binding.addGroup.text.clear()
    }
    fun spinnerCategory(spinner: Spinner, list: List<String>){
        val adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, list)
        spinner.setAdapter(adapter)
    }

    override fun onItemSelected(item: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val groups = App.instance?.getDatabase()?.FakultetDao()?.getAllCategory()
        for (i in groups!!){
            if (item?.selectedItem == i.nameFakultet){
                facultyId = i.idFakultet
            }
        }
    }

    override fun onNothingSelected(item: AdapterView<*>?) {
    }
}

