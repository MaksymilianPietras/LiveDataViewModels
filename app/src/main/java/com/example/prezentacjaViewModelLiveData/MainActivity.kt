package com.example.prezentacjaViewModelLiveData

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
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

        //Data Binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val user = User(20)
        binding.user = user

        binding.buttonAge.setOnClickListener {
            user.age++
            binding.user = user
        }


        // ViewModel LiveData
        viewModel = ViewModelProvider(this)[ExampleViewModel::class.java]
        viewModel!!.text.observe(this) { newText ->
            println("OBSERWATOR WIDZI ZMIANE")
            binding.textView.text = newText
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel!!.increaseCounter()
            viewModel!!.updateText("LiveData: ${viewModel!!.count.value}")
        }

    }

}