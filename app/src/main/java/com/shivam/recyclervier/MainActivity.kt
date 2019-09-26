package com.shivam.recyclervier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), PersonAdapter.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = PersonAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.update(loadPersons())
    }

    private fun loadPersons() : ArrayList<Person> {
        val person = ArrayList<Person>()
        for (i in 1..500) {
            person.add(Person(UUID.randomUUID().toString(),
                "Shivam Mathur",
                "Android Software Developer",
                "Philips India",
                "https://randomuser.me/api/portraits/men/$i.jpg"))
        }
        return person
    }

    override fun onSelectListener(imageView: ImageView, item: Person) {
        Toast.makeText(applicationContext, "${item.id} : ${item.name}", Toast.LENGTH_SHORT).show()
    }
}
