package com.example.prezentacjaViewModelLiveData

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.prezentacjaViewModelLiveData.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var viewModel: ExampleViewModel? = null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this)[ExampleViewModel::class.java]
        binding.viewModel = viewModel

        val user = User(20)
        binding.user = user

        viewModel!!.text.observe(this) { newText ->
            println("OBSERWATOR WIDZI ZMIANE")
            binding.textView.text = newText
        }

        binding.button.setOnClickListener {
            viewModel!!.increaseCounter()
            viewModel!!.updateText("Live Data: ${viewModel!!.count.value}")
        }

        binding.buttonAge.setOnClickListener {

            user.age++
            binding.user = user
        }
    }

}