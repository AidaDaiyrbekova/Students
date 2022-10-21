package com.example.students.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.students.App
import com.example.students.R
import com.example.students.db.Students
import java.util.ArrayList

class StudentsAdapter(private var array: ArrayList<Students>, val context: FragmentActivity): RecyclerView.Adapter<StudentsAdapter.ViewHolder> (){
    fun setList(array: Array<Students>) {
        this.array = array.toMutableList() as ArrayList<Students>

    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var sName = view.findViewById<TextView>(R.id.surName)
        var fName=view.findViewById<TextView>(R.id.fName)
        var patr=view.findViewById<TextView>(R.id.patr)
        var bDb=view.findViewById<TextView>(R.id.dBd)
        var delete=view.findViewById<ImageButton>(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_students, parent, false)
        return ViewHolder(view)
    }
    private var onItemClickListener: ((Students) -> Unit)? = null


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = array[position]
        holder.let { point ->
            point.sName.text = current.sName
            point.fName.text = current.name
            point.patr.text = current.patronymic
            point.bDb.text = current.dBd.toString()
            point.delete.setOnClickListener {
                val db = App.instance?.getDatabase()?.StudentsDao()
                db?.delStudent(current)
                notifyItemRemoved(position)
                notifyDataSetChanged()
                array.removeAt(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, array.size);

            }

        }
    }


    override fun getItemCount(): Int {
        return array.size
    }
}