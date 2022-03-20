package com.fakhry.wetalk12

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fakhry.wetalk12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initListener()
    }

    private fun initListener() {
        binding.btnIncrease.setOnClickListener {
            viewModel.increaseNumber()
        }

        binding.btnDecrease.setOnClickListener {
            viewModel.decreaseNumber()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.number.observe(this) { number ->
            binding.tvCounter.text = number.toString()
        }
    }
}