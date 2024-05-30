package com.example.prezentacjaViewModelLiveData

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {
    private var viewModel: ExampleViewModel? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ExampleViewModel::class.java]

        viewModel!!.text.observe(this) { newText ->
            println("OBSERWATOR WIDZI ZMIANE")
            findViewById<TextView>(R.id.textView).text = newText
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel!!.increaseCounter()
            viewModel!!.updateText("Zmiana nr: ${viewModel!!.count.value}")
        }
    }
}