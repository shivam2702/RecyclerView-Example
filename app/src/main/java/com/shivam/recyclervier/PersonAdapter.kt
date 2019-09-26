package com.shivam.recyclervier

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_person.view.*

class PersonAdapter(var listener: OnClickListener) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    private var mySpeakers: List<Person> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_person,
            parent,
            false
        ), parent.context
    )

    override fun getItemCount(): Int = mySpeakers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(mySpeakers[position])

    fun update(myList: List<Person>) {
        this.mySpeakers = myList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View, var context: Context) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(item: Person) {
            itemView.name.text = item.name
            itemView.company.text = item.company

            Glide
                .with(context)
                .load(item.imageUrl)
                .into(itemView.image)

            itemView.setOnClickListener {
                listener.onSelectListener(itemView.image, item)
            }
        }
    }

    interface OnClickListener {
        fun onSelectListener(imageView: ImageView, item: Person)
    }
}