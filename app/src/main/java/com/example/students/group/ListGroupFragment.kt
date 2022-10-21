package com.example.students.group

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.students.App
import com.example.students.adapters.GroupsAdapter
import com.example.students.R
import com.example.students.databinding.FragmentListGroupBinding


class ListGroupFragment : Fragment() {
  private lateinit var binding: FragmentListGroupBinding
    private val args:ListGroupFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListGroupBinding.inflate(inflater,container,false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val group = App.instance?.getDatabase()?.GroupsDao()?.getAllGroup()
        val filteredArray = group?.filter { it.fkFakultet == args.facultyId } as ArrayList
        val recyclerView = binding.groupsRecyclerview
        recyclerView.adapter = GroupsAdapter(filteredArray, requireActivity())

        binding.toolbar.toolbarTxt.text="Список групп"
        binding.toolbar.backBtn.setOnClickListener {
            findNavController().navigate(R.id.listFakultetFragment)
        }
    }
}