package com.example.Mouth7Work1.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Mouth7Work1.R
import com.example.Mouth7Work1.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding
    private var productName: String? = null
    private var count: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLauncherRealization()
    }

    private fun initLauncherRealization() {
        binding.btnClicker.setOnClickListener {
            if (binding.etName.text?.isEmpty() == true || binding.etCount.text?.isEmpty() == true) {
                Toast.makeText(this, getString(R.string.redactor_toast), Toast.LENGTH_SHORT)
                    .show()
            } else {
                productName = binding.etName.text.toString()
                count = binding.etCount.text.toString().toInt()
                setResult(RESULT_OK, intent.putExtra(MainActivity.USER_KEY, productName))
                setResult(RESULT_OK, intent.putExtra(MainActivity.USER_KEY_COUNT, count))
                finish()
            }
        }
    }
}