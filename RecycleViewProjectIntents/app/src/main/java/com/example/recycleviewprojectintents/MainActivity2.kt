package com.example.recycleviewprojectintents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.example.recycleviewprojectintents.Data.Companion.imagestwo
import com.example.recycleviewprojectintents.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?: return
        val qString = extras.getString("qString")
        val qString2 = extras.getString("qString2")
        val qImage = extras.getInt("qImage")
        binding.textViewTop.text = qString
        binding.textViewMiddle.text = qString2
        binding.imageView.setImageResource(imagestwo[qImage])



    }
}