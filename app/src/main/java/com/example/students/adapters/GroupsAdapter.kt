package com.example.students.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.db.Groups
import com.example.students.group.ListGroupFragmentDirections
import java.util.ArrayList

class GroupsAdapter(private var array: ArrayList<Groups>, val context: FragmentActivity): RecyclerView.Adapter<GroupsAdapter.ViewHolder> (){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.title_group)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_group, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameGroup
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(ListGroupFragmentDirections.actionListGroupFragmentToListStudentFragment(item.idGroup!!))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}