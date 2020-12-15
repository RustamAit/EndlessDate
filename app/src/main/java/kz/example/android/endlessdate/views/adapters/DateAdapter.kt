package kz.example.android.endlessdate.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_date.view.*
import kz.example.android.endlessdate.R
import kz.example.android.endlessdate.core.utills.formatDate
import java.util.*

class DateAdapter(private val dataset: List<Date>, private val listener: OnDateItemInteractionListener): RecyclerView.Adapter<DateAdapter.DateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DateViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_date, parent, false))

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    inner class DateViewHolder(v: View): RecyclerView.ViewHolder(v){
        fun bind(d: Date){
            itemView.dateTextView.text = d.formatDate("EEE, MMM d, ''yy")
            itemView.setOnClickListener {
                listener.onDateItemClick(d)
            }
        }
    }



}