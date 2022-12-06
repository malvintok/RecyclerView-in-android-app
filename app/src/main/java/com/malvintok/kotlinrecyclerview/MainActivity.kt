package com.malvintok.kotlinrecyclerview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.malvintok.kotlinrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 5 STEPS OF IMPLEMENTING a RecyclerView:
        // 1. Define a model class to use as the data source
        // 2. Add a RecyclerView to your activity to display the items
        // 3. Create a custom row layout XML file to visualize the item
        // 4. Create a RecyclerView.Adapter and ViewHolder to render the item
        // 5. Bind the adapter to the data source to populate the RecyclerView
        // Source: https://guides.codepath.com/android/using-the-recyclerview

        val contacts = createContacts()
        binding.rvContacts.adapter = ContactAdapter(this, contacts)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
    }

    private fun createContacts(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        for (i in 1..150) contacts.add(Contact("Person #$i", i))
        return contacts
    }
}