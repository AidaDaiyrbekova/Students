package com.example.students.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.students.R
import com.example.students.db.Fakultet
import com.example.students.fakultet.ListFakultetFragmentDirections

class FacultyAdapter(private var array: Array<Fakultet>, val context: FragmentActivity): RecyclerView.Adapter<FacultyAdapter.ViewHolder> (){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var title = view.findViewById<TextView>(R.id.title_faculty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_faculty, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = item.nameFakultet
        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(ListFakultetFragmentDirections.actionListFakultetFragmentToListGroupFragment(item.idFakultet!!))
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}